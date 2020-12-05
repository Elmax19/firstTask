package com.epam.jwd.example.model;

import com.epam.jwd.example.Main;
import com.epam.jwd.example.exception.FigureException;
import com.epam.jwd.example.service.impl.FigureExistencePostProcessor;
import org.apache.logging.log4j.Level;

public class Factory {
    public Figure createFigure(Point[] arr) {

        if (samePoints(arr)) {
            Main.LOGGER.log(Level.ERROR, "В фигуре есть одинаковые точки");
            return null;
        }

        Figure figure;
        FigureExistencePostProcessor newFigure = new FigureExistencePostProcessor();
        switch (arr.length) {
            case 0:
            case 1:
            case 2:
                Main.LOGGER.log(Level.ERROR, "В фигуре должно быть больше 2-х точек");
                return null;
            case 3:
                figure = new Triangle(arr);
                break;
            case 4:
                figure = new Square(arr);
                break;
            default:
                figure = new MultiAngleFigure(arr);
        }

        try {
            figure = newFigure.process(figure);
            return figure;
        } catch (FigureException e) {
            Main.LOGGER.log(Level.ERROR, e.getMessage());
            return null;
        }
    }

    public boolean samePoints(Point[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}

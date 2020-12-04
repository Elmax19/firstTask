package com.epam.jwd.example.model;

import com.epam.jwd.example.Main;
import com.epam.jwd.example.exception.FigureException;
import com.epam.jwd.example.service.impl.FigureExistencePostProcessor;
import org.apache.logging.log4j.Level;

public class SquareFactory extends Factory {

    @Override
    public Square createFigure(Point[] arr) {
        FigureExistencePostProcessor figure = new FigureExistencePostProcessor();
        Square square;
        try {
            square = (Square) figure.process(new Square(arr));
        } catch (FigureException e) {
            Main.LOGGER.log(Level.ERROR, e.getMessage());
            return null;
        }
        return square;
    }
}

package com.epam.jwd.example.model;

import com.epam.jwd.example.Main;
import com.epam.jwd.example.exception.FigureException;
import com.epam.jwd.example.service.impl.FigureExistencePostProcessor;
import org.apache.logging.log4j.Level;

public class TriangleFactory extends Factory {

    @Override
    public Triangle createFigure(Point[] arr) {
        FigureExistencePostProcessor figure = new FigureExistencePostProcessor();
        Triangle triangle;
        try {
            triangle = (Triangle) figure.process(new Triangle(arr));
        } catch (FigureException e) {
            Main.LOGGER.log(Level.ERROR, e.getMessage());
            return null;
        }
        return triangle;
    }


}

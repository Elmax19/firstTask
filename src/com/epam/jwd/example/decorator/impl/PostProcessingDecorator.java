package com.epam.jwd.example.decorator.impl;

import com.epam.jwd.example.app.FigureType;
import com.epam.jwd.example.Main;
import com.epam.jwd.example.app.Point;
import com.epam.jwd.example.decorator.api.FigureFactory;
import com.epam.jwd.example.decorator.api.FigurePostProcessor;
import com.epam.jwd.example.exception.FigureException;
import org.apache.logging.log4j.Level;

public class PostProcessingDecorator implements FigureFactory {
    private final FigurePostProcessor postProcessor = new FigureExistencePostProcessor();

    private final FigureFactory figureFactory;

    public PostProcessingDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure createFigure(FigureType type, Point[] points) {
        try {
            Figure figure = figureFactory.createFigure(type, points);
            if (figure != null) {
                figure = postProcessor.process(figure);
            }
            return figure;
        } catch (FigureException e) {
            Main.LOGGER.log(Level.ERROR, e.getMessage());
            return null;
        }
    }
}

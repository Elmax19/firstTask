package com.epam.jwd.example.decorator.impl;

import com.epam.jwd.example.app.FigureType;
import com.epam.jwd.example.app.Main;
import com.epam.jwd.example.app.Point;
import com.epam.jwd.example.exception.FigureException;
import com.epam.jwd.example.decorator.api.FigureFactory;
import com.epam.jwd.example.decorator.api.FigurePreProcessor;
import org.apache.logging.log4j.Level;

public class PreProcessingDecorator implements FigureFactory {
    private final FigurePreProcessor preProcessor = new SamePoints();

    private final FigureFactory figureFactory;

    public PreProcessingDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure createFigure(FigureType type, Point[] points) {
        try {
            preProcessor.preProcess(points);
            return figureFactory.createFigure(type, points);
        } catch (FigureException e) {
            Main.LOGGER.log(Level.ERROR, e.getMessage());
            return null;
        }
    }
}

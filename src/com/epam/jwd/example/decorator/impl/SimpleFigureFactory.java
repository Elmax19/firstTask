package com.epam.jwd.example.decorator.impl;

import com.epam.jwd.example.FigureType;
import com.epam.jwd.example.Point;
import com.epam.jwd.example.decorator.api.FigureFactory;

public class SimpleFigureFactory implements FigureFactory {
    @Override
    public Figure createFigure(FigureType type, Point[] points) {
        switch (type) {
            case TRIANGLE:
                return new Triangle(points);
            case SQUARE:
                return new Square(points);
            case MULTI_ANGLE_FIGURE:
                return new MultiAngleFigure(points);
            default:
                return null;
        }
    }
}

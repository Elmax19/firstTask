package com.epam.jwd.example.decorator.impl;

import com.epam.jwd.example.Point;
import com.epam.jwd.example.exception.FigureException;
import com.epam.jwd.example.decorator.api.FigurePreProcessor;

public class SamePoints implements FigurePreProcessor {
    @Override
    public void preProcess(Point[] points) throws FigureException {
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].equals(points[j])) {
                    throw new FigureException("Есть одинаковые точки!");
                }
            }
        }
    }
}


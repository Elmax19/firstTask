package com.epam.jwd.example.decorator.api;

import com.epam.jwd.example.app.Point;
import com.epam.jwd.example.exception.FigureException;

public interface FigurePreProcessor {
    void preProcess(Point[] points) throws FigureException;
}

package com.epam.jwd.example.model;

import com.epam.jwd.example.Point;

public abstract class Factory {
    public abstract Figure createNewFigure();
    public abstract Figure createFigure(Point[] arr);
}

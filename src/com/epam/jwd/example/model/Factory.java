package com.epam.jwd.example.model;

public abstract class Factory {
    public abstract Figure createNewFigure();
    public abstract Figure createFigure(Point[] arr);
}

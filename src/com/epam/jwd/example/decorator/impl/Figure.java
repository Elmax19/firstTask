package com.epam.jwd.example.decorator.impl;

import com.epam.jwd.example.Point;
import com.epam.jwd.example.strategy.Strategy;

public abstract class Figure {

    Point[] a;
    private Strategy figurePropertiesStrategy;

    public Point[] getArray() {
        return a;
    }

    public void setArray(Point[] array) {
        this.a = array;
    }

    public Strategy getFigurePropertiesStrategy() {
        return figurePropertiesStrategy;
    }

    public void setFigurePropertiesStrategy(Strategy figurePropertiesStrategy) {
        this.figurePropertiesStrategy = figurePropertiesStrategy;
    }

    public abstract boolean mayExist();
}

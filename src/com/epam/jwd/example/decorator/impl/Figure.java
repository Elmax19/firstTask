package com.epam.jwd.example.decorator.impl;

import com.epam.jwd.example.app.Point;
import com.epam.jwd.example.strategy.Strategy;

import java.util.Arrays;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Arrays.equals(a, figure.a) &&
                Objects.equals(figurePropertiesStrategy, figure.figurePropertiesStrategy);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(figurePropertiesStrategy);
        result = 31 * result + Arrays.hashCode(a);
        return result;
    }

    public abstract boolean mayExist();
}

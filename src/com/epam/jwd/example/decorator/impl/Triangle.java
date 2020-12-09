package com.epam.jwd.example.decorator.impl;

import com.epam.jwd.example.app.Point;
import com.epam.jwd.example.strategy.TriangleStrategy;

public class Triangle extends Figure {

    protected Triangle(Point[] arr) {
        this.a = arr;
        setFigurePropertiesStrategy(TriangleStrategy.singletonEnum.INSTANCE.getStrategy());
    }

    @Override
    public boolean mayExist() {
        return (a[0].getX() - a[1].getX()) * (a[2].getY() - a[1].getY()) !=
                (a[0].getY() - a[1].getY()) * (a[2].getX() - a[1].getX());
    }

    @Override
    public String toString() {
        String message;
        message = "Triangle(" + a[0].toString() + ", " + a[1].toString() + ", " + a[2].toString() + ")";
        return message;
    }
}

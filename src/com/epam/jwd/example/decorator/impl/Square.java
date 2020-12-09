package com.epam.jwd.example.decorator.impl;

import com.epam.jwd.example.app.Point;
import com.epam.jwd.example.strategy.SquareStrategy;

public class Square extends Figure {

    protected Square(Point[] arr) {
        this.a = arr;
        setFigurePropertiesStrategy(SquareStrategy.getInstance());
    }

    @Override
    public boolean mayExist() {
        Point[] array1 = {a[0], a[2], a[1], a[3]};
        Point[] array2 = {a[1], a[0], a[2], a[3]};
        return (isSquare(a) || isSquare(array1) || isSquare(array2));
    }

    public boolean isSquare(Point[] array) {
        boolean k1 = isParallel(array[0], array[1], array[2]);
        boolean k2 = isParallel(array[0], array[3], array[2]);
        return k1 && k2 && (getFigurePropertiesStrategy().getDistance(array[0], array[1]) ==
                getFigurePropertiesStrategy().getDistance(array[2], array[3]));
    }

    public boolean isParallel(Point a, Point b, Point c) {
        return (a.getX() - b.getX()) * (c.getX() - b.getX()) +
                (a.getY() - b.getY()) * (c.getY() - b.getY()) == 0;
    }

    @Override
    public String toString() {
        String message;
        message = "Square(" + a[0].toString() + ", " + a[1].toString() +
                ", " + a[2].toString() + ", " + a[3].toString() + ")";
        return message;
    }
}

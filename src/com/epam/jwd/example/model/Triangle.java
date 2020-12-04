package com.epam.jwd.example.model;

import com.epam.jwd.example.strategy.TriangleStrategy;

public class Triangle extends Figure {

    Triangle(){
        this.a = new Point[]{new Point(), new Point(), new Point()};
        setFigurePropertiesStrategy(TriangleStrategy.singletonEnum.INSTANCE.getStrategy());
    }

    Triangle(Point a, Point b, Point c) {
        this.a = new Point[]{a, b, c};
        setFigurePropertiesStrategy(new TriangleStrategy());
    }

    @Override
    public boolean mayExist(){
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

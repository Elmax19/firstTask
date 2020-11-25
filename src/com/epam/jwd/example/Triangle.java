package com.epam.jwd.example;

import com.epam.jwd.strategy.triangleStrategy;

public class Triangle extends Figure {
    private Point[] array = new Point[3];

    public Triangle(){
        this.array[0] = new Point();
        this.array[1] = new Point();
        this.array[2] = new Point();
        setFigurePropertiesStrategy(new triangleStrategy());
    }

    public Triangle(Point a, Point b, Point c) {
        this.array[0] = a;
        this.array[1] = b;
        this.array[2] = c;
        setFigurePropertiesStrategy(new triangleStrategy());
    }

    public Point[] getArray() {
        return array;
    }

    public void setArray(Point[] array) {
        this.array = array;
    }

    public boolean mayExist(){
        return (array[0].getX() - array[1].getX()) * (array[2].getY() - array[1].getY()) !=
                (array[0].getY() - array[1].getY()) * (array[2].getX() - array[1].getX());
    }

    @Override
    public String toString() {
        String message;
        message = "Triangle(" + array[0].toString() + ", " + array[1].toString() + ", " + array[2].toString() + ")";
        return message;
    }
}

package com.epam.jwd.example;

import com.epam.jwd.strategy.squareStrategy;
import com.epam.jwd.strategy.triangleStrategy;

public class Square extends Figure {
    private Point[] array = new Point[4];

    public Square(){
        this.array[0] = new Point();
        this.array[1] = new Point();
        this.array[2] = new Point();
        this.array[3] = new Point();
        setFigurePropertiesStrategy(new squareStrategy());
    }

    public Square(Point a, Point b, Point c, Point d) {
        this.array[0] = a;
        this.array[1] = b;
        this.array[2] = c;
        this.array[3] = d;
        setFigurePropertiesStrategy(new squareStrategy());
    }

    public Point[] getArray() {
        return array;
    }

    public void setArray(Point[] array) {
        this.array = array;
    }

    public boolean mayExist() {
        Point [] array1 = {array[0], array[2], array[1], array[3]};
        Point [] array2 = {array[1], array[0], array[2], array[3]};
        return isSquare(array) || isSquare(array1) || isSquare(array2);
    }

    public boolean isSquare(Point[] array) {
        boolean k1 = isParallel(array[0], array[1], array[2]);
        boolean k2 = isParallel(array[0], array[3], array[2]);
        return k1 && k2 && (getFigurePropertiesStrategy().getDistance(array[0], array[1]) ==
                getFigurePropertiesStrategy().getDistance(array[2], array[3]));
    }

    public boolean isParallel(Point a, Point b, Point c){
        return (a.getX() - b.getX()) * (c.getX() - b.getX()) +
                (a.getY() - b.getY()) * (c.getY() - b.getY()) == 0;
    }

    @Override
    public String toString() {
        String message;
        message = "Square(" + array[0].toString() + ", " + array[1].toString() +
                ", " + array[2].toString() + ", " + array[3].toString() + ")";
        return message;
    }
}

package com.epam.jwd.example.app;

public class Line {
    private Point[] array = new Point[2];

    public Line() {
        this.array[0] = new Point();
        this.array[1] = new Point();
    }

    public Line(Point a, Point b) {
        this.array[0] = a;
        this.array[1] = b;
    }

    public Point[] getArray() {
        return array;
    }

    public void setArray(Point[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        String message;
        message = "Line(" + array[0].toString() + ", " + array[1].toString() + ")";
        return message;
    }
}

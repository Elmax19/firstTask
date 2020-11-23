package com.epam.jwd;

public class Line {
    private Point a;
    private Point b;

    public Line(){
        this.a = new Point();
        this.b = new Point();
    }

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    @Override
    public String toString() {
        String message;
        message = "Line(" + a.toString() + ", " + b.toString() + ")";
        return message;
    }
}

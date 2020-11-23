package com.epam.jwd;

public class Triangle implements Figure {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(){
        this.a = new Point();
        this.b = new Point();
        this.c = new Point();
    }

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
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

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    @Override
    public double getDistance(Point a, Point b){
        double x = a.getX() - b.getX();
        double y = a.getY() - b.getY();
        double distance = x * x + y * y;
        distance = Math.sqrt(distance);
        return distance;
    }

    @Override
    public boolean mayExist(){
        return (a.getX() - b.getX()) * (c.getY() - b.getY()) != (a.getY() - b.getY()) * (c.getX() - b.getX());
    }

    @Override
    public String toString() {
        String message;
        message = "Triangle(" + a.toString() + ", " + b.toString() + ", " + c.toString() + ")";
        return message;
    }
}

package com.epam.jwd;

public class Square implements Figure {
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Square(){
        this.a = new Point();
        this.b = new Point();
        this.c = new Point();
        this.d = new Point();
    }

    public Square(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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

    public Point getD() {
        return d;
    }

    public void setD(Point d) {
        this.d = d;
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
    public boolean mayExist() {

        return isSquare(a,b,c,d) || isSquare(a,c,b,d) || isSquare(b,a,c,d);
    }

    public boolean isSquare(Point a, Point b, Point c, Point d) {
        boolean k1 = (a.getX() - b.getX()) * (c.getX() - b.getX()) + (a.getY() - b.getY()) * (c.getY() - b.getY()) == 0;
        boolean k2 = (a.getX() - d.getX()) * (c.getX() - d.getX()) + (a.getY() - d.getY()) * (c.getY() - d.getY()) == 0;
        return k1 && k2 && (getDistance(a, b) == getDistance(b, c));
    }

    @Override
    public String toString() {
        String message;
        message = "Square(" + a.toString() + ", " + b.toString() + ", " + c.toString() + ", " + d.toString() + ")";
        return message;
    }
}

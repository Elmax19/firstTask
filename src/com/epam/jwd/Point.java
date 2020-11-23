package com.epam.jwd;

public class Point {
    private int x;
    private int y;

    public Point() {
        this.x  = (int) (Math.random() * 20 - 10);
        this.y  = (int) (Math.random() * 20 - 10);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point("+this.x+','+this.y+')';
    }
}

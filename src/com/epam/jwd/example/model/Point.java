package com.epam.jwd.example.model;

import java.util.Objects;

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

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point("+this.x+','+this.y+')';
    }
}

package com.epam.jwd.example.strategy;

import com.epam.jwd.example.Point;

public final class TriangleStrategy implements Strategy {

    private double x;
    private double y;
    private double z;

    public enum singletonEnum {
        INSTANCE;

        private final TriangleStrategy STRATEGY = new TriangleStrategy();

        public TriangleStrategy getStrategy() {
            return this.STRATEGY;
        }
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public double getDistance(Point a, Point b) {
        double x = a.getX() - b.getX();
        double y = a.getY() - b.getY();
        double distance = x * x + y * y;
        distance = Math.sqrt(distance);
        return distance;
    }

    @Override
    public double perimeter(Point[] array) {
        setX(getDistance(array[0], array[1]));
        setY(getDistance(array[1], array[2]));
        setZ(getDistance(array[0], array[2]));
        return x + y + z;
    }

    @Override
    public double square(Point[] array) {
        double p = perimeter(array) / 2;
        double rez = p * (p - x) * (p - y) * (p - z);
        return Math.sqrt(rez);
    }
}
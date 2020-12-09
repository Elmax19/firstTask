package com.epam.jwd.example.strategy;

import com.epam.jwd.example.Point;

public final class SquareStrategy implements Strategy {

    private SquareStrategy() {
    }

    private static class SingletonHolder {
        private final static SquareStrategy INSTANCE = new SquareStrategy();
    }

    public static SquareStrategy getInstance() {
        return SquareStrategy.SingletonHolder.INSTANCE;
    }

    @Override
    public double perimeter(Point[] array) {
        double x = getDistance(array[0], array[1]);
        double y = getDistance(array[0], array[2]);
        double z = getDistance(array[0], array[3]);
        if (x == y || x == z) {
            return x * 4;
        }
        return y * 4;
    }

    @Override
    public double square(Point[] array) {
        double a = perimeter(array) / 4;
        return a * a;
    }

    @Override
    public double getDistance(Point a, Point b) {
        double x = a.getX() - b.getX();
        double y = a.getY() - b.getY();
        double distance = x * x + y * y;
        distance = Math.sqrt(distance);
        return distance;
    }
}

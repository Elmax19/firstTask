package com.epam.jwd.example.strategy;

import com.epam.jwd.example.model.Point;

public final class MultiAngleStrategy implements Strategy {
    private static final MultiAngleStrategy INSTANCE = new MultiAngleStrategy();

    private MultiAngleStrategy() {
    }

    public static MultiAngleStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public double perimeter(Point[] array) {
        double rez = 0;
        int n = array.length;
        for (int i = 0; i < array.length - 1; i++) {
            rez += getDistance(array[i], array[i + 1]);
        }
        rez += getDistance(array[n - 1], array[0]);
        return rez;
    }

    @Override
    public double square(Point[] array) {
        double rez = 0;
        int n = array.length;
        rez += array[0].getX() * (array[n - 1].getY() - array[1].getY());
        for (int i = 1; i < n - 1; i++) {
            rez += array[i].getX() * (array[i - 1].getY() - array[i + 1].getY());
        }
        rez += array[n - 1].getX() * (array[n - 2].getY() - array[0].getY());
        rez /= 2;
        return Math.abs(rez);
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

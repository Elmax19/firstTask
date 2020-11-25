package com.epam.jwd.strategy;

import com.epam.jwd.example.Point;

public interface Strategy {
    double perimeter(Point[] array);
    double square(Point[] array);
    double getDistance(Point a, Point b);
}
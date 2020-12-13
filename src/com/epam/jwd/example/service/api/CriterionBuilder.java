package com.epam.jwd.example.service.api;

import com.epam.jwd.example.app.Point;

import java.util.ArrayList;

public interface CriterionBuilder {
    void addPoint(Point point);
    void addNumberOfPoints(int n);
}

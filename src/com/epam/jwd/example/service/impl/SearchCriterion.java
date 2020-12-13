package com.epam.jwd.example.service.impl;

import com.epam.jwd.example.app.Point;
import com.epam.jwd.example.service.api.CriterionBuilder;

public class SearchCriterion implements CriterionBuilder {
    private Point point = null;
    private int count = 0;

    @Override
    public void addPoint(Point point) {
        this.point = point;
    }

    @Override
    public void addNumberOfPoints(int n) {
        this.count=n;
    }

    public Point getPoint() {
        return point;
    }

    public int getCount() {
        return count;
    }
}

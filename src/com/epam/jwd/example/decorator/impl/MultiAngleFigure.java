package com.epam.jwd.example.decorator.impl;

import com.epam.jwd.example.Point;
import com.epam.jwd.example.strategy.MultiAngleStrategy;

public class MultiAngleFigure extends Figure {

    MultiAngleFigure(Point[] a) {
        this.setArray(a);
        setFigurePropertiesStrategy((MultiAngleStrategy.getInstance()));
    }

    @Override
    public boolean mayExist() {
        return true;
    }

    @Override
    public String toString() {
        StringBuilder message;
        Point[] arr = getArray();
        message = new StringBuilder("MultiAngleFigure(" + arr[0].toString());
        for (int i = 1; i < arr.length; i++) {
            message.append(", ").append(arr[i].toString());
        }
        message.append(")");
        return message.toString();
    }
}

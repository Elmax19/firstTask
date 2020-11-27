package com.epam.jwd.example.model;

import com.epam.jwd.example.Point;

public interface Factory {
    Figure createNewFigure();
    Figure createFigure(Point[] arr);
}

package com.epam.jwd.example.service.api;

import com.epam.jwd.example.app.FigureType;
import com.epam.jwd.example.app.Point;
import com.epam.jwd.example.decorator.impl.Figure;
import com.epam.jwd.example.service.impl.FigureStorage;
import com.epam.jwd.example.service.impl.Specification;

import java.util.ArrayList;

public interface FigureCrud {
    void create(FigureType type, Point[] points);

    void multiCreate(FigureType type, ArrayList<Point[]> figures);

    void delete(FigureType type, Figure figure);

    Figure find(Figure figure);

    Figure findById(FigureStorage<?> storage, int id);

    Figure findBySpecification(Specification specification);
}

package com.epam.jwd.example.service.api;

import com.epam.jwd.example.app.Point;
import com.epam.jwd.example.decorator.impl.Figure;
import com.epam.jwd.example.service.impl.SearchCriterion;

import java.util.ArrayList;

public interface FigureCrud {
    void create(Figure figure);

    void multiCreate(ArrayList<Figure> figures);

    void delete(Figure figure);

    Figure find(Figure figure);

    void update();

    Figure findById(int id);

    Figure findByCriterion(SearchCriterion criterion);
}

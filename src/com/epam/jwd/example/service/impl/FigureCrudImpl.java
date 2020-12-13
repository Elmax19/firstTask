package com.epam.jwd.example.service.impl;

import com.epam.jwd.example.app.Point;
import com.epam.jwd.example.decorator.impl.Figure;
import com.epam.jwd.example.service.api.FigureCrud;

import java.util.ArrayList;

public class FigureCrudImpl implements FigureCrud {
    private static final FigureCrudImpl INSTANCE = new FigureCrudImpl();
    private ArrayList<Figure> storage = new ArrayList<>();

    public FigureCrudImpl() {
    }

    public static FigureCrudImpl getInstance() {
        return INSTANCE;
    }

    public ArrayList<Figure> getStorage(){
        return storage;
    }

    @Override
    public void create(Figure figure) {
        storage.add(figure);
    }

    @Override
    public void multiCreate(ArrayList<Figure> figures) {
        for(Figure figure : figures){
            if (find(figure)==null){
                create(figure);
            }
        }
    }

    @Override
    public void delete(Figure figure) {
        Figure figureInStorage = find(figure);
        if (figureInStorage != null) {
            storage.remove(figureInStorage);
        }
    }

    @Override
    public Figure find(Figure figure) {
        for(Figure figures : storage){
            if (figures.equals(figure)){
                return figures;
            }
        }
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public Figure findById(int id) {
        return storage.get(id);
    }

    @Override
    public Figure findByCriterion(SearchCriterion criterion) {
        for(Figure figures : storage){
            Point[] points = figures.getArray();
            if (points.length == criterion.getCount()) {
                for (Point point : points) {
                    if (point.equals(criterion.getPoint())) {
                        return figures;
                    }
                }
            }
        }
        return null;
    }
}

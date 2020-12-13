package com.epam.jwd.example.decorator.impl;

import com.epam.jwd.example.service.impl.FigureCrudImpl;
import com.epam.jwd.example.app.FigureType;
import com.epam.jwd.example.app.Point;
import com.epam.jwd.example.decorator.api.FigureFactory;

import java.util.ArrayList;

public class SimpleFigureFactory implements FigureFactory {

    private final ArrayList<Figure> figureStorage = FigureCrudImpl.getInstance().getStorage();
    @Override
    public Figure createFigure(FigureType type, Point[] points) {
        Figure figure;
        switch (type) {
            case TRIANGLE:
                figure = find(new Triangle(points));
                if (figure == null){
                    figure = new Triangle(points);
                    FigureCrudImpl.getInstance().create(figure);
                }
                break;
            case SQUARE:
                figure = find(new Square(points));
                if (figure == null){
                    figure = new Square(points);
                    FigureCrudImpl.getInstance().create(figure);
                }
                break;
            default:
                figure = find(new MultiAngleFigure(points));
                if (figure == null){
                    figure = new MultiAngleFigure(points);
                    FigureCrudImpl.getInstance().create(figure);
                }
                break;
        }
        return figure;
    }

    private Figure find(Figure figure){
        for (Figure storage : figureStorage) {
            if (figure.equals(storage)) {
                return storage;
            }
        }
        return null;
    }
}

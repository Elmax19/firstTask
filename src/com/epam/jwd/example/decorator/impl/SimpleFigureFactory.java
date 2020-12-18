package com.epam.jwd.example.decorator.impl;

import com.epam.jwd.example.app.FigureType;
import com.epam.jwd.example.app.Main;
import com.epam.jwd.example.app.Point;
import com.epam.jwd.example.decorator.api.FigureFactory;
import com.epam.jwd.example.service.impl.FigureCrudImpl;

public class SimpleFigureFactory implements FigureFactory {
    @Override
    public Figure createFigure(FigureType type, Point[] points) {
        switch (type) {
            case TRIANGLE:
                return addTriangle(points);
            case SQUARE:
                return addSquare(points);
            default:
                return addMultiAngle(points);
        }
    }

    private Triangle addTriangle(Point[] points) {
        Triangle figure = (Triangle) FigureCrudImpl.getInstance().find(new Triangle(points));
        if (figure == null) {
            figure = new Triangle(points);
            Main.TRIANGLE_FIGURE_STORAGE_STORAGE.addIntoStorage(figure);
        }
        return figure;
    }

    private Square addSquare(Point[] points) {
        Square figure = (Square) FigureCrudImpl.getInstance().find(new Square(points));
        if (figure == null) {
            figure = new Square(points);
            Main.SQUARE_FIGURE_STORAGE_STORAGE.addIntoStorage(figure);
        }
        return figure;
    }

    private MultiAngleFigure addMultiAngle(Point[] points) {
        MultiAngleFigure figure = (MultiAngleFigure) FigureCrudImpl.getInstance().find(new MultiAngleFigure(points));
        if (figure == null) {
            figure = new MultiAngleFigure(points);
            Main.MULTI_ANGLE_FIGURE_STORAGE.addIntoStorage(figure);
        }
        return figure;
    }
}

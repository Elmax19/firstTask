package com.epam.jwd.example.service.impl;

import com.epam.jwd.example.app.FigureType;
import com.epam.jwd.example.app.Main;
import com.epam.jwd.example.app.Point;
import com.epam.jwd.example.decorator.api.FigureFactory;
import com.epam.jwd.example.decorator.impl.ApplicationContext;
import com.epam.jwd.example.decorator.impl.Figure;
import com.epam.jwd.example.decorator.impl.MultiAngleFigure;
import com.epam.jwd.example.decorator.impl.Square;
import com.epam.jwd.example.decorator.impl.Triangle;
import com.epam.jwd.example.service.api.FigureCrud;

import java.util.ArrayList;

public class FigureCrudImpl implements FigureCrud {

    private final FigureFactory FIGURE_FACTORY = ApplicationContext.singletonEnum.INSTANCE.createFigureFactory();
    private final static FigureCrudImpl INSTANCE = new FigureCrudImpl();

    private FigureCrudImpl() {
    }

    public static FigureCrudImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void create(FigureType type, Point[] points) {
        FIGURE_FACTORY.createFigure(type, points);
    }

    @Override
    public void multiCreate(FigureType type, ArrayList<Point[]> figures) {
        for (Point[] figure : figures) {
            create(type, figure);
        }
    }

    @Override
    public void delete(FigureType type, Figure figure) {
        Figure figureInStorage = find(figure);
        if (check(type, figure) && figureInStorage != null) {
            switch (type) {
                case TRIANGLE:
                    Main.TRIANGLE_FIGURE_STORAGE_STORAGE.getStorage().remove(figureInStorage);
                case SQUARE:
                    Main.SQUARE_FIGURE_STORAGE_STORAGE.getStorage().remove(figureInStorage);
                default:
                    Main.MULTI_ANGLE_FIGURE_STORAGE.getStorage().remove(figureInStorage);
            }
        }
    }

    private boolean check(FigureType type, Figure figure) {
        switch (type) {
            case TRIANGLE:
                return figure.getArray().length == 3;
            case SQUARE:
                return figure.getArray().length == 4;
            default:
                return figure.getArray().length > 4;
        }
    }

    @Override
    public Figure find(Figure figure) {
        switch (figure.getArray().length){
            case 3:
                for (Triangle figures : Main.TRIANGLE_FIGURE_STORAGE_STORAGE.getStorage()) {
                    if (figures.equals(figure)) {
                        return figures;
                    }
                }
                break;
            case 4:
                for (Square figures : Main.SQUARE_FIGURE_STORAGE_STORAGE.getStorage()) {
                    if (figures.equals(figure)) {
                        return figures;
                    }
                }
                break;
            default:
                for (MultiAngleFigure figures : Main.MULTI_ANGLE_FIGURE_STORAGE.getStorage()) {
                    if (figures.equals(figure)) {
                        return figures;
                    }
                }
                break;
        }
        return null;
    }

    @Override
    public Figure findById(FigureStorage<?> storage, int id) {
        return storage.getStorage().get(id);
    }

    @Override
    public Figure findBySpecification(Specification specification) {
        switch (specification.getTYPE()) {
            case TRIANGLE:
                return findTriangle(specification);
            case SQUARE:
                return findSquare(specification);
            default:
                return findMultiAngle(specification);
        }
    }

    private Triangle findTriangle(Specification specification) {
        for (Triangle triangle : Main.TRIANGLE_FIGURE_STORAGE_STORAGE.getStorage()) {
            Point[] arr = triangle.getArray();
            if (specification.getPERIMETER() == triangle.getFigurePropertiesStrategy().perimeter(arr) &&
                    specification.getSQUARE() == triangle.getFigurePropertiesStrategy().square(arr)) {
                for (Point point : arr) {
                    if (point.equals(specification.getPOINT())) {
                        return triangle;
                    }
                }
            }
        }
        return null;
    }

    private Square findSquare(Specification specification) {
        for (Square square : Main.SQUARE_FIGURE_STORAGE_STORAGE.getStorage()) {
            Point[] arr = square.getArray();
            if (specification.getPERIMETER() == square.getFigurePropertiesStrategy().perimeter(arr) &&
                    specification.getSQUARE() == square.getFigurePropertiesStrategy().square(arr)) {
                for (Point point : arr) {
                    if (point.equals(specification.getPOINT())) {
                        return square;
                    }
                }
            }
        }
        return null;
    }

    private MultiAngleFigure findMultiAngle(Specification specification) {
        for (MultiAngleFigure figure : Main.MULTI_ANGLE_FIGURE_STORAGE.getStorage()) {
            Point[] arr = figure.getArray();
            if (specification.getPERIMETER() == figure.getFigurePropertiesStrategy().perimeter(arr) &&
                    specification.getSQUARE() == figure.getFigurePropertiesStrategy().square(arr)) {
                for (Point point : arr) {
                    if (point.equals(specification.getPOINT())) {
                        return figure;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void update(FigureStorage storage, Figure figure, int id) {
        storage.getStorage().remove(id);
        storage.addIntoStorage(figure);
    }
}

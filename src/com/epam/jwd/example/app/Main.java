package com.epam.jwd.example.app;

import com.epam.jwd.example.decorator.impl.Figure;
import com.epam.jwd.example.decorator.impl.MultiAngleFigure;
import com.epam.jwd.example.decorator.impl.Square;
import com.epam.jwd.example.decorator.impl.Triangle;
import com.epam.jwd.example.service.impl.FigureCrudImpl;
import com.epam.jwd.example.service.impl.FigureStorage;
import com.epam.jwd.example.service.impl.Specification;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public final static FigureStorage<Triangle> TRIANGLE_FIGURE_STORAGE_STORAGE = new FigureStorage();
    public final static FigureStorage<Square> SQUARE_FIGURE_STORAGE_STORAGE = new FigureStorage();
    public final static FigureStorage<MultiAngleFigure> MULTI_ANGLE_FIGURE_STORAGE = new FigureStorage();

    private final static FigureCrudImpl FIGURE_CRUD = FigureCrudImpl.getInstance();
    private final static Point[] FIRST_ARR = new Point[4];
    private final static Line[] SECOND_ARR = new Line[2];

    public static void main(String[] args) {
        declaration();
        getInfo();
    }


    public static void getInfo() {
        getInfoAboutPoints();

        for (Line arr : SECOND_ARR) {
            getInfoAboutLines(arr);
        }

        for (Triangle figure : TRIANGLE_FIGURE_STORAGE_STORAGE.getStorage()) {
            getInfoAboutFigures(figure);
        }
        for (Square figure : SQUARE_FIGURE_STORAGE_STORAGE.getStorage()) {
            getInfoAboutFigures(figure);
        }
        for (MultiAngleFigure figure : MULTI_ANGLE_FIGURE_STORAGE.getStorage()) {
            getInfoAboutFigures(figure);
        }

        final Specification specification = Specification.builder()
                .perimeter(20)
                .square(25)
                .type(FigureType.SQUARE)
                .point(new Point(5, 5))
                .build();

        findBySpecification(specification);
        FIGURE_CRUD.delete(FigureType.SQUARE, SQUARE_FIGURE_STORAGE_STORAGE.getStorage().get(0));
        findBySpecification(specification);
    }

    private static void findBySpecification(Specification specification) {
        Figure figure = FIGURE_CRUD.findBySpecification(specification);
        if (figure == null) {
            LOGGER.log(Level.ERROR, "Фигура не найдена");
        } else {
            LOGGER.log(Level.INFO, figure.toString());
        }
    }

    public static void declaration() {
        for (int i = 0; i < 4; i++) {
            FIRST_ARR[i] = new Point();
        }

        for (int i = 0; i < 2; i++) {
            SECOND_ARR[i] = new Line();
        }

        FIGURE_CRUD.create(FigureType.TRIANGLE, new Point[]{new Point(0, 0), new Point(0, 5), new Point(5, 5)});
        FIGURE_CRUD.create(FigureType.TRIANGLE, new Point[]{new Point(0, 0), new Point(0, 5), new Point(5, 5)});

        FIGURE_CRUD.create(FigureType.SQUARE, new Point[]{new Point(0, 0), new Point(5, 5),
                new Point(0, 5), new Point(5, 0)});

        FIGURE_CRUD.create(FigureType.MULTI_ANGLE_FIGURE, new Point[]{new Point(0, 0), new Point(3, 2),
                new Point(0, 5), new Point(5, 5), new Point(3, -1)});
        FIGURE_CRUD.create(FigureType.MULTI_ANGLE_FIGURE, new Point[]{new Point(2, 0), new Point(4, 0),
                new Point(6, 2), new Point(6, 4), new Point(4, 6), new Point(2, 6),
                new Point(0, 4), new Point(0, 2)});

    }

    public static boolean samePoints(Point[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void getInfoAboutPoints() {
        int i = 0;
        do {
            LOGGER.log(Level.INFO, FIRST_ARR[i].toString());
            i++;
        } while (i < 4);
    }

    public static void getInfoAboutLines(Line line) {
        if (!samePoints(line.getArray())) {
            LOGGER.log(Level.INFO, line.toString());
        } else {
            LOGGER.log(Level.ERROR, "Объект Line не является фигурой <<Линия>>");
        }
    }

    public static void getInfoAboutFigures(Figure figure) {
        Point[] array = figure.getArray();

        LOGGER.log(Level.INFO, figure.toString());
        LOGGER.log(Level.INFO, String.format("Периметр равен %1$.3f",
                figure.getFigurePropertiesStrategy().perimeter(array)));
        LOGGER.log(Level.INFO, String.format("Площадь равна %1$.3f",
                figure.getFigurePropertiesStrategy().square(array)));
    }
}
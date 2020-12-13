package com.epam.jwd.example.app;

import com.epam.jwd.example.decorator.api.FigureFactory;
import com.epam.jwd.example.decorator.impl.ApplicationContext;
import com.epam.jwd.example.decorator.impl.Figure;
import com.epam.jwd.example.decorator.impl.MultiAngleFigure;
import com.epam.jwd.example.decorator.impl.Square;
import com.epam.jwd.example.decorator.impl.Triangle;
import com.epam.jwd.example.service.impl.FigureCrudImpl;
import com.epam.jwd.example.service.impl.SearchCriterion;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Main {

    public static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final FigureFactory FIGURE_FACTORY = ApplicationContext.singletonEnum.INSTANCE.createFigureFactory();

    private final static Point[] FIRST_ARR = new Point[4];
    private final static Line[] SECOND_ARR = new Line[2];
    private final static Triangle[] THIRD_ARR = new Triangle[2];
    private final static Square[] FOURTH_ARR = new Square[1];
    private final static MultiAngleFigure[] FIFTH_ARR = new MultiAngleFigure[2];

    public static void main(String[] args) {
        declaration();
        getInfo();
    }


    public static void getInfo() {
        getInfoAboutPoints();

        for (Line arr : SECOND_ARR) {
            getInfoAboutLines(arr);
        }

        ArrayList<Figure> figures = FigureCrudImpl.getInstance().getStorage();
        for(Figure figure : figures){
            getInfoAboutFigures(figure);
        }

        findByCriterion(new Point(5,5), 4);
        FigureCrudImpl.getInstance().delete(FOURTH_ARR[0]);
        findByCriterion(new Point(5,5), 4);
    }

    public static void declaration() {
        for (int i = 0; i < 4; i++) {
            FIRST_ARR[i] = new Point();
        }

        for (int i = 0; i < 2; i++) {
            SECOND_ARR[i] = new Line();
        }
        THIRD_ARR[0] = (Triangle) FIGURE_FACTORY.createFigure(FigureType.TRIANGLE, new Point[]{new Point (0,0), new Point (0,5), new Point (5,5)});
        THIRD_ARR[1] = (Triangle) FIGURE_FACTORY.createFigure(FigureType.TRIANGLE, new Point[]{new Point (0,0), new Point (0,5), new Point (5,5)});

        FOURTH_ARR[0] = (Square) FIGURE_FACTORY.createFigure(FigureType.SQUARE, new Point[]{new Point(0, 0), new Point(5, 5),
                new Point(0, 5), new Point(5, 0)});

        FIFTH_ARR[0] = (MultiAngleFigure) FIGURE_FACTORY.createFigure(FigureType.MULTI_ANGLE_FIGURE, new Point[]{new Point(0, 0), new Point(3, 2),
                new Point(0, 5), new Point(5, 5), new Point(3, -1)});
        FIFTH_ARR[1] = (MultiAngleFigure) FIGURE_FACTORY.createFigure(FigureType.MULTI_ANGLE_FIGURE, new Point[]{new Point(2, 0), new Point(4, 0),
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

    public static void getInfoAboutLines(Line arr) {
        if (!samePoints(arr.getArray())) {
            LOGGER.log(Level.INFO, arr.toString());
        } else {
            LOGGER.log(Level.ERROR, "Объект Line не является фигурой <<Линия>>");
        }
    }

    public static void getInfoAboutFigures(Figure arr) {
        Point[] array = arr.getArray();

        LOGGER.log(Level.INFO, arr.toString());
        LOGGER.log(Level.INFO, String.format("Периметр равен %1$.3f",
                arr.getFigurePropertiesStrategy().perimeter(array)));
        LOGGER.log(Level.INFO, String.format("Площадь равна %1$.3f",
                arr.getFigurePropertiesStrategy().square(array)));
    }

    public static void findByCriterion(Point point, int count){
        SearchCriterion criterion = new SearchCriterion();
        criterion.addPoint(point);
        criterion.addNumberOfPoints(count);
        Square squareFromStorage = (Square) FigureCrudImpl.getInstance().findByCriterion(criterion);
        if (squareFromStorage!=null){
            LOGGER.log(Level.INFO, squareFromStorage.toString());
        }
        else{
            LOGGER.log(Level.INFO, "Фигура не был найдена");
        }
    }
}
package com.epam.jwd.example;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static Point[] firstArr = new Point[4];
    private static Line[] secondArr = new Line[2];
    private static Triangle[] thirdArr = new Triangle[2];
    private static Square[] fourthArr = new Square[1];

    public static void main(String[] args) {
        declaration();
        getInfo();
    }

    public static boolean samePoints(Point[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].getX() == array[j].getX() && array[i].getY() == array[j].getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void getInfo(){
        getInfoAboutPoints();

        for (Line arr : secondArr) {
            getInfoAboutLines(arr);
        }

        for(Triangle arr : thirdArr) {
            getInfoAboutTriangles(arr);
        }

        for(Square arr : fourthArr) {
            getInfoAboutSquare(arr);
        }
    }

    public static void declaration(){
        for (int i = 0; i < 4; i++) {
            firstArr[i] = new Point();
        }

        for (int i = 0; i < 2; i++) {
            secondArr[i] = new Line();
            thirdArr[i] = new Triangle();
        }

        fourthArr[0] = new Square();
    }

    public static void getInfoAboutPoints(){
        int i=0;
        do{
            LOGGER.log(Level.INFO, firstArr[i].toString());
            i++;
        }while (i<4);
    }

    public static void getInfoAboutLines(Line arr) {
            if(!samePoints(arr.getArray())) {
                LOGGER.log(Level.INFO, arr.toString());
            }
            else{
                LOGGER.log(Level.ERROR, "Объект Line не является фигурой <<Линия>>");
            }
    }

    public static void getInfoAboutTriangles(Triangle arr) {
        Point[] array = arr.getArray();
        if (!samePoints(new Point[]{array[0], array[1]}) && !samePoints(new Point[]{array[1], array[2]}) &&
                !samePoints(new Point[]{array[0], array[2]})) {
            if (arr.mayExist()) {
                LOGGER.log(Level.INFO, arr.toString());
                LOGGER.log(Level.INFO, String.format("Периметр равен %1$.3f",
                        arr.getFigurePropertiesStrategy().perimeter(array)));
                LOGGER.log(Level.INFO, String.format("Площадь равна равен %1$.3f",
                        arr.getFigurePropertiesStrategy().square(array)));
            } else {
                LOGGER.log(Level.ERROR, "Объект Triangle не может существовать");
            }
        } else {
            LOGGER.log(Level.ERROR, "Объект Triangle не является фигурой <<Треугольник>>");
        }
    }

    public static void getInfoAboutSquare(Square arr) {
        Point[] array = arr.getArray();
        if (!samePoints(new Point[]{array[0], array[1]}) && !samePoints(new Point[]{array[0], array[2]}) &&
                !samePoints(new Point[]{array[0], array[3]}) && !samePoints(new Point[]{array[1], array[2]}) &&
                !samePoints(new Point[]{array[1], array[3]}) && !samePoints(new Point[]{array[0], array[1]})) {
            if (arr.mayExist()) {
                LOGGER.log(Level.INFO, arr.toString());
                LOGGER.log(Level.INFO, String.format("Периметр равен %1$.3f",
                        arr.getFigurePropertiesStrategy().perimeter(array)));
                LOGGER.log(Level.INFO, String.format("Площадь равна равен %1$.3f",
                        arr.getFigurePropertiesStrategy().square(array)));
            } else {
                LOGGER.log(Level.ERROR, "Объект Square не является квадратом");
            }
        } else {
            LOGGER.log(Level.ERROR, "Объект Square не является фигурой <<Квадрат>>");
        }
    }
}
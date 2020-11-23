package com.epam.jwd;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        int i;

        // Объявление массивов
        Point[] firstArr = new Point[4];
        Line[] secondArr = new Line[2];
        Triangle[] thirdArr = new Triangle[2];
        Square[] fourthArr = new Square[1];

        // Заполнение массивов данными
        for (i = 0; i < 4; i++) {
            firstArr[i] = new Point();
        }

        for (i = 0; i < 2; i++) {
            secondArr[i] = new Line();
            thirdArr[i] = new Triangle();
        }

        /* Тест, когда фигура не линия
        secondArr[0] = new Line(new Point(0,4), new Point(0,4));
        secondArr[1] = new Line();
        */

        /* Тесты, когда треугольник существовать не может
        thirdArr[0] = new Triangle(new Point(4,4), new Point(1,1), new Point(3,3));
        thirdArr[1] = new Triangle(new Point(4,1), new Point(4,4), new Point(4,-2));
        */

        /* Тест, когда фигура не треугольник
        thirdArr[0] = new Triangle(new Point(0,4), new Point(3,7), new Point(0,4));
        thirdArr[1] = new Triangle();
        */

        fourthArr[0] = new Square();

        /* Тесты, когда квадрат существует
        fourthArr[0] = new Square(new Point(0,0), new Point(3,3), new Point(3,0), new Point(0,3));
        fourthArr[0] = new Square(new Point(0,4), new Point(3,7), new Point(6,4), new Point(3,1));
         */

        /* Тест, когда фигура не квадрат
        fourthArr[0] = new Square(new Point(0,4), new Point(3,7), new Point(3,7), new Point(0,4));
        */

        // Вывод информации о элеменах массива Point
        i=0;
        do{
            LOGGER.log(Level.INFO, firstArr[i].toString());
            i++;
        }while (i<4);

        // Вывод информации о элеменах массива Line (6.1)
            for (Line arr : secondArr) {
                if(!samePoints(arr.getA(), arr.getB())) {         // (6.4)
                    LOGGER.log(Level.INFO, arr.toString());
                }
                else{
                    LOGGER.log(Level.ERROR, "Объект Line не является фигурой <<Линия>>");
                }
            }

        // Вывод информации о элеменах массива Triangle (6.2)
        for(Triangle arr : thirdArr){
            if(!samePoints(arr.getA(), arr.getB()) && !samePoints(arr.getA(), arr.getC()) &&
                    !samePoints(arr.getB(), arr.getC())) {                                       // (6.4)
                if (arr.mayExist()) {
                    LOGGER.log(Level.INFO, arr.toString());
                } else {
                    LOGGER.log(Level.ERROR, "Объект Triangle не может существовать");
                }
            }
            else{
                LOGGER.log(Level.ERROR, "Объект Triangle не является фигурой <<Треугольник>>");
            }
        }

        // Вывод информации о элементе массива Square (6.3)
        for(Square arr : fourthArr){
            if(!samePoints(arr.getA(), arr.getB()) && !samePoints(arr.getA(), arr.getC()) &&
                    !samePoints(arr.getA(), arr.getD()) && !samePoints(arr.getB(), arr.getC()) &&
                    !samePoints(arr.getB(), arr.getD()) && !samePoints(arr.getC(), arr.getD())) {     // (6.4)
                if (arr.mayExist()) {
                    LOGGER.log(Level.INFO, arr.toString());
                } else {
                    LOGGER.log(Level.ERROR, "Объект Square не является квадратом");
                }
            }
            else{
                LOGGER.log(Level.ERROR, "Объект Square не является фигурой <<Квадрат>>");
            }
        }

    }

    public static boolean samePoints(Point a, Point b) {
        return (a.getX() == b.getX()) && (a.getY() == b.getY());
    }
}

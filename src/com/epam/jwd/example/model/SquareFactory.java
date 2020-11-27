package com.epam.jwd.example.model;

import com.epam.jwd.example.Point;

public class SquareFactory extends Factory {

    public Square createNewFigure(){
        return new Square();
    }

    @Override
    public Square createFigure(Point[] arr){
        return new Square(arr[0], arr[1], arr[2], arr[3]);
    }

}

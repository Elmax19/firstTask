package com.epam.jwd.example.model;

import com.epam.jwd.example.Point;

public class Factory {

    public Triangle createNewTriangle(){
        return new Triangle();
    }
    public Triangle createTriangle(Point[] arr){
        return new Triangle(arr[0], arr[1], arr[2]);
    }

    public Square createNewSquare(){
        return new Square();
    }
    public Square createSquare(Point[] arr){
        return new Square(arr[0], arr[1], arr[2], arr[3]);
    }

    public MultiAngleFigure createNewFigure(){
        return new MultiAngleFigure();
    }
    public MultiAngleFigure createFigure(Point[] arr){
        return new MultiAngleFigure(arr);
    }
}

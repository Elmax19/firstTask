package com.epam.jwd.example.model;

public class TriangleFactory extends Factory{

    @Override
    public Triangle createNewFigure(){
        return new Triangle();
    }

    @Override
    public Triangle createFigure(Point[] arr){
        return new Triangle(arr[0], arr[1], arr[2]);
    }


}

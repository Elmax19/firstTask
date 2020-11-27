package com.epam.jwd.example.model;

import com.epam.jwd.example.Point;

public class TriangleFactory implements Factory{

    @Override
    public Triangle createNewFigure(){
        return new Triangle();
    }

    @Override
    public Triangle createFigure(Point[] arr){
        return new Triangle(arr[0], arr[1], arr[2]);
    }


}

package com.epam.jwd.example.model;

public class FigureFactory extends Factory{

    @Override
    public MultiAngleFigure createNewFigure(){
        return new MultiAngleFigure();
    }

    @Override
    public MultiAngleFigure createFigure(Point[] arr){
        return new MultiAngleFigure(arr);
    }

}

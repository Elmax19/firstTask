package com.epam.jwd.example.model;

import com.epam.jwd.example.Point;

public class FigureFactory implements Factory{

    @Override
    public MultiAngleFigure createNewFigure(){
        return new MultiAngleFigure();
    }

    @Override
    public MultiAngleFigure createFigure(Point[] arr){
        return new MultiAngleFigure(arr);
    }

}

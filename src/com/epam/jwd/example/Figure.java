package com.epam.jwd.example;

import com.epam.jwd.strategy.Strategy;

public abstract class Figure {

    private Strategy figurePropertiesStrategy;

    public Strategy getFigurePropertiesStrategy() {
        return figurePropertiesStrategy;
    }

    public void setFigurePropertiesStrategy(Strategy figurePropertiesStrategy) {
        this.figurePropertiesStrategy = figurePropertiesStrategy;
    }

    abstract boolean  mayExist();
}

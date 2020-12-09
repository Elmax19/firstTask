package com.epam.jwd.example.decorator.impl;

import com.epam.jwd.example.decorator.api.FigurePostProcessor;
import com.epam.jwd.example.exception.FigureNotExistException;

public class FigureExistencePostProcessor implements FigurePostProcessor {
    @Override
    public Figure process(Figure figure) throws FigureNotExistException {
        if (!figure.mayExist()) {
            throw new FigureNotExistException("Фигура " + figure.toString() + " не может существовать");
        }
        return figure;
    }
}

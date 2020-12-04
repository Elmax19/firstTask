package com.epam.jwd.example.service.impl;

import com.epam.jwd.example.exception.FigureException;
import com.epam.jwd.example.exception.FigureNotExistException;
import com.epam.jwd.example.model.Figure;
import com.epam.jwd.example.service.FigurePostProcessor;

public class FigureExistencePostProcessor implements FigurePostProcessor {
    @Override
    public Figure process(Figure figure) throws FigureNotExistException {
        if (!figure.mayExist()) {
            throw new FigureNotExistException("Фигура " + figure.toString() +" не может существовать");
        }
        return figure;
    }
}

package com.epam.jwd.example.service;

import com.epam.jwd.example.exception.FigureException;
import com.epam.jwd.example.model.Figure;

public interface FigurePostProcessor {
    Figure process(Figure figure) throws FigureException;
}

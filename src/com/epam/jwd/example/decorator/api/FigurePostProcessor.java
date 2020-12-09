package com.epam.jwd.example.decorator.api;

import com.epam.jwd.example.exception.FigureException;
import com.epam.jwd.example.decorator.impl.Figure;

public interface FigurePostProcessor {
    Figure process(Figure figure) throws FigureException;
}

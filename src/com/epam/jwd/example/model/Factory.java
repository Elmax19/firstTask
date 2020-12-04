package com.epam.jwd.example.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Factory {
    private static final Logger LOGGER = LogManager.getLogger(Factory.class);

    public abstract Figure createFigure(Point[] arr);
}

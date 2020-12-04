package com.epam.jwd.example.exception;

import java.io.PrintStream;

public class FigureNotExistException extends FigureException {
    public FigureNotExistException(String message) {
        super(message);
    }
}

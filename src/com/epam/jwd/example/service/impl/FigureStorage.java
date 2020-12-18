package com.epam.jwd.example.service.impl;

import com.epam.jwd.example.decorator.impl.Figure;

import java.util.ArrayList;

public class FigureStorage<T extends Figure> {
    private final ArrayList<T> storage = new ArrayList();

    public FigureStorage() {
    }

    public ArrayList<T> getStorage() {
        return storage;
    }

    public void addIntoStorage(T figure) {
        storage.add(figure);
    }
}

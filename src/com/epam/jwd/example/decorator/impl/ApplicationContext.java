package com.epam.jwd.example.decorator.impl;

import com.epam.jwd.example.decorator.api.FigureFactory;

public class ApplicationContext {
    public enum singletonEnum {
        INSTANCE;

        public FigureFactory createFigureFactory() {
            return new PostProcessingDecorator(new PreProcessingDecorator(new SimpleFigureFactory()));
        }
    }
}

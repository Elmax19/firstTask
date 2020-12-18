package com.epam.jwd.example.service.impl;

import com.epam.jwd.example.app.FigureType;
import com.epam.jwd.example.app.Point;

import java.util.Objects;

public class Specification {
    private final double SQUARE;
    private final double PERIMETER;
    private final FigureType TYPE;
    private final Point POINT;

    private Specification(double square, double perimeter, FigureType type, Point point) {
        this.SQUARE = square;
        this.PERIMETER = perimeter;
        this.TYPE = type;
        this.POINT = point;
    }

    public double getSQUARE() {
        return SQUARE;
    }

    public double getPERIMETER() {
        return PERIMETER;
    }

    public FigureType getTYPE() {
        return TYPE;
    }

    public Point getPOINT() {
        return POINT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specification that = (Specification) o;
        return Double.compare(that.SQUARE, SQUARE) == 0 &&
                Double.compare(that.PERIMETER, PERIMETER) == 0 &&
                TYPE == that.TYPE &&
                Objects.equals(POINT, that.POINT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(SQUARE, PERIMETER, TYPE, POINT);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private double square;
        private double perimeter;
        private FigureType type;
        private Point point;

        public Builder square(double square) {
            this.square = square;
            return this;
        }

        public Builder perimeter(double perimeter) {
            this.perimeter = perimeter;
            return this;
        }

        public Builder type(FigureType type) {
            this.type = type;
            return this;
        }

        public Builder point(Point point) {
            this.point = point;
            return this;
        }

        public double getSquare() {
            return square;
        }

        public double getPerimeter() {
            return perimeter;
        }

        public FigureType getType() {
            return type;
        }

        public Point getPoint() {
            return point;
        }

        public Specification build() {
            return new Specification(
                    this.square,
                    this.perimeter,
                    this.type,
                    this.point);
        }
    }
}

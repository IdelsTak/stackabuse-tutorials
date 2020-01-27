/*
 * Copyright 2020.
 */
package com.stackabuse.tutorials.overriding;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hiram K. <hiram.kamau@outlook.com>
 */
public class AreaCalculator {

    private static final Logger LOG = Logger.getLogger(AreaCalculator.class.getName());

    public static void main(String[] args) {
        var side = 5;
        Shape shape = new Square(side);

        logDetails(shape);

        var base = 10;
        var height = 6.5;
        shape = new Triangle(base, height);

        logDetails(shape);

    }

    private static void logDetails(Shape shape) {
        var description = shape.toString();
        var area = shape.calculateArea();
        
        LOG.log(Level.INFO, "Area of {0} = {1}", new Object[]{description, area});
    }

    abstract class Shape {

        abstract Number calculateArea();
    }

    static class Triangle extends Shape {

        private final double base;
        private final double height;

        Triangle(double base, double height) {
            this.base = base;
            this.height = height;
        }

        @Override
        Double calculateArea() {
            return (base / 2) * height;
        }

        @Override
        public String toString() {
            return String.format(
                    "Triangle with a base of %s and height of %s",
                    new Object[]{base, height});
        }

    }

    static class Square extends Shape {

        private final double side;

        Square(double side) {
            this.side = side;
        }

        @Override
        Double calculateArea() {
            return side * side;
        }

        @Override
        public String toString() {
            return String.format("Square with a side length of %s units", side);
        }

    }
}

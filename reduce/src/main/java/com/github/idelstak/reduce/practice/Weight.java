/*
 * Copyright 2021
 */
package com.github.idelstak.reduce.practice;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class Weight {

    public static final Weight NIL = new Weight(0.0);
    private final double value;

    public Weight(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public Weight add(Weight otherWeight) {
        return new Weight(value + otherWeight.getValue());
    }

    public Weight getTotal(int quantity) {
        return new Weight(value * quantity);
    }

    @Override
    public String toString() {
        return String.format("Unit weight: %.2f lbs", value);
    }

}

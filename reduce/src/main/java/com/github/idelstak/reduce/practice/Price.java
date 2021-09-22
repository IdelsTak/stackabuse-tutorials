/*
 * Copyright 2021
 */
package com.github.idelstak.reduce.practice;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class Price {

    public static final Price NIL = new Price(0.0);
    private final double value;

    public Price(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public Price add(Price otherPrice) {
        return new Price(value + otherPrice.getValue());
    }

    public Price getTotal(int quantity) {
        return new Price(value * quantity);
    }
    
    public Price getMin(Price otherPrice){
        return new Price(Double.min(value, otherPrice.getValue()));
    }
    
    public Price getMax(Price otherPrice){
        return new Price(Double.max(value, otherPrice.getValue()));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.value) ^ (Double.doubleToLongBits(this.value) >>> 32));
        return hash;
    }

    @Override
    @SuppressWarnings("AccessingNonPublicFieldOfAnotherObject")
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Price other = (Price) obj;
        return Double.doubleToLongBits(this.value) == Double.doubleToLongBits(other.value);
    }

    @Override
    public String toString() {
        return String.format("Unit price: $ %.2f", value);
    }

}

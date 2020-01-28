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
public class Minimum extends Number {

    private static final Logger LOG = Logger.getLogger(Minimum.class.getName());

    private final int first;
    private final int second;

    public Minimum(int first, int second) {
        super();
        this.first = first;
        this.second = second;
    }

    public static void main(String[] args) {
        int minimumInt = new Minimum(5, 40).intValue();

        LOG.log(Level.INFO, "Minimum = {0}", minimumInt);
    }

    @Override
    public int intValue() {
        return (first <= second)
               ? first
               : second;
    }

    @Override
    public long longValue() {
        return Long.valueOf(intValue());
    }

    @Override
    public float floatValue() {
        return (float) intValue();
    }

    @Override
    public double doubleValue() {
        return (double) intValue();
    }

}

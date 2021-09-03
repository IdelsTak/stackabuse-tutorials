/*
 * Copyright 2021
 */
package com.github.idelstak.stream.filter;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public abstract class FilterFigures {

    private final double exponent;

    public FilterFigures(double exponent) {
        this.exponent = exponent;
    }

    public abstract void doFilter();

    protected List<Double> getRandomFigures() {
        return ThreadLocalRandom.current()
                .doubles((long) Math.pow(10, exponent), 1, 4)
                .boxed()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                Collections::unmodifiableList
                        )
                );
    }
}

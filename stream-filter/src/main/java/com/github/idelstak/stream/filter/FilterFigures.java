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

    private final ThreadLocalRandom random = ThreadLocalRandom.current();
    private int figuresCount = 1;

    public abstract void doFilter();

    private int getFiguresCount() {
        figuresCount *= 10;

        return figuresCount;
    }

    protected List<Double> getRandomFigures() {
        return random
                .doubles(this.getFiguresCount(), 1, 4)
                .boxed()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                Collections::unmodifiableList
                        )
                );
    }
}

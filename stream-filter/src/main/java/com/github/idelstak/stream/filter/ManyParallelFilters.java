/*
 * Copyright 2021
 */
package com.github.idelstak.stream.filter;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class ManyParallelFilters extends FilterFigures {

    @Override
    public void doFilter() {
        for (int i = 0; i < 4; i++) {
            long count = super.getRandomFigures()
                    .stream()
                    .parallel()
                    .filter(figure -> figure < Math.PI)
                    .filter(figure -> figure > Math.E)
                    .filter(figure -> figure != 3)
                    .filter(figure -> figure != 2)
                    .count();
        }
    }
}

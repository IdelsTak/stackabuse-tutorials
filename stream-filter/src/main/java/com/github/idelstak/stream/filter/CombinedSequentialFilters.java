/*
 * Copyright 2021
 */
package com.github.idelstak.stream.filter;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class CombinedSequentialFilters extends FilterFigures {

    @Override
    public void doFilter() {
        for (int i = 0; i < 4; i++) {
            long figuresMeetingCriteria = super.getRandomFigures()
                    .stream()
                    .filter(
                            figure -> figure < Math.PI
                            && figure > Math.E
                            && figure != 3
                            && figure != 2
                    )
                    .count();
        }
    }

}

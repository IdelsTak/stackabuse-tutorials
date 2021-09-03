/*
 * Copyright 2021
 */
package com.github.idelstak.stream.filter;

import java.util.List;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class ClassicForLoop extends FilterFigures {

    public ClassicForLoop(double exponent) {
        super(exponent);
    }

    @Override
    public void doFilter() {
        List<Double> randomFigures = super.getRandomFigures();
        long count = 0;

        for (int j = 0; j < randomFigures.size(); j++) {
            Double figure = randomFigures.get(j);

            if (figure < Math.PI
                    && figure > Math.E
                    && figure != 3
                    && figure != 2) {
                count = count + 1;
            }
        }
    }

}

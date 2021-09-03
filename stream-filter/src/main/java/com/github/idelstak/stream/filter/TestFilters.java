/*
 * Copyright 2021
 */
package com.github.idelstak.stream.filter;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class TestFilters {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int numberOfTests = 10_000;

        for (int i = 0; i < numberOfTests; i++) {
            new ManySequentialFilters().doFilter();
        }

        long endTime = System.currentTimeMillis();
        System.out
                .printf("Time taken by many sequential filters = %d ms\n", (endTime - startTime));

        startTime = System.currentTimeMillis();

        for (int i = 0; i < numberOfTests; i++) {
            new ManyParallelFilters().doFilter();
        }

        endTime = System.currentTimeMillis();
        System.out
                .printf("Time taken by many parallel filters = %d ms\n", (endTime - startTime));

        startTime = System.currentTimeMillis();

        for (int i = 0; i < numberOfTests; i++) {
            new CombinedSequentialFilters().doFilter();
        }

        endTime = System.currentTimeMillis();
        System.out
                .printf("Time taken by combined sequential filters = %d ms\n", (endTime - startTime));

        startTime = System.currentTimeMillis();

        for (int i = 0; i < numberOfTests; i++) {
            new CombinedSequentialFilters().doFilter();
        }

        endTime = System.currentTimeMillis();
        System.out
                .printf("Time taken by combined parallel filters = %d ms\n", (endTime - startTime));

        startTime = System.currentTimeMillis();

        for (int i = 0; i < numberOfTests; i++) {
            new ClassicForLoop().doFilter();
        }

        endTime = System.currentTimeMillis();
        System.out
                .printf("Time taken by filtering using classic for loop = %d ms\n", (endTime - startTime));
    }

}

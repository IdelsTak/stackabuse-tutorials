/*
 * Copyright 2021
 */
package com.github.idelstak.reduce;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class ParallelReduce {

    private final int max;

    public ParallelReduce(int max) {
        this.max = max;
    }

    public int iterateSum() {
        Stream<Integer> iterateStream = Stream.iterate(1, number -> number + 1);
        Integer iterateSum = iterateStream
                .limit(max)
                .parallel()
                .reduce(0, (number1, number2) -> number1 + number2);
        return iterateSum;
    }

    public int rangeSum() {
        IntStream rangeClosedStream = IntStream.rangeClosed(1, max);
        int rangeClosedSum = rangeClosedStream
                .parallel()
                .reduce(0, (number1, number2) -> number1 + number2);
        return rangeClosedSum;
    }
}

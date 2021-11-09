/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen;

import java.util.function.Function;
import java.util.stream.Collector;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class Definition {

    private Definition() {
    }

    public static <T, A, R, RR> Collector<T, A, RR> collectingAndThen(Collector<T, A, R> downstream, Function<R, RR> finisher) {
        throw new UnsupportedOperationException("Not supported yet");
    }
}

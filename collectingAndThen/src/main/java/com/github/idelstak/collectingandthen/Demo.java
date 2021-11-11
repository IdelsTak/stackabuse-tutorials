/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class Demo {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3);

        Collector downstream = toCollection(ArrayList::new);
        Function finisher = list -> unmodifiableList((List<Integer>) list);
        Collector collector = collectingAndThen(downstream, finisher);

        List<Integer> list = (List<Integer>) stream.collect(collector);
    }
}

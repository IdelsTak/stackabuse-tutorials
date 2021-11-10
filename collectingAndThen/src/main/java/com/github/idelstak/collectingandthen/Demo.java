/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class Demo {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        
        Collector<Integer, ?, List<Integer>> downstream = Collectors.toCollection(() -> new ArrayList<Integer>());
        Function<List<Integer>, List<Integer>> finisher = list -> Collections.unmodifiableList(list);
        Collector<Integer, ?, List<Integer>> collector = Collectors.collectingAndThen(downstream, finisher);
        
        List<Integer> list = stream.collect(collector);
    }
}

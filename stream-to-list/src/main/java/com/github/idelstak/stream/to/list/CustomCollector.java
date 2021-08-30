/*
 * Copyright 2021
 */
package com.github.idelstak.stream.to.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class CustomCollector implements Collector<String, List<String>, List<String>> {

    @Override
    public Supplier<List<String>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<String>, String> accumulator() {
        return List::add;
    }

    @Override
    public BinaryOperator<List<String>> combiner() {
        return (bloodGroups, otherBloodGroups) -> {
            bloodGroups.addAll(otherBloodGroups);
            return bloodGroups;
        };
    }

    @Override
    public Function<List<String>, List<String>> finisher() {
        return Collections::unmodifiableList;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }

}

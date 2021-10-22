/*
 * Copyright 2021
 */
package com.github.idelstak.flatmap;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class DuplicatedStream {

    private final Stream<?> objectsStream;

    public DuplicatedStream(Stream<?> stream) {
        this.objectsStream = stream;
    }

    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6);
        
        DuplicatedStream ds = new DuplicatedStream(numbers);

        ds.duplicate();
    }

    public void duplicate() {
        Function<Object, Stream<Object>> mapper = i -> Stream.of(i, i);
        
        objectsStream
                .flatMap(mapper)
                .forEach(System.out::print);
    }
}

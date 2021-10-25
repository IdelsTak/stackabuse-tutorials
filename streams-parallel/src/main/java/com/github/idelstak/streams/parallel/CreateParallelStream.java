/*
 * Copyright 2021
 */
package com.github.idelstak.streams.parallel;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class CreateParallelStream {

    public CreateParallelStream() {
        Collection<Integer> numbers = Arrays.asList(1, 2, 3);
        
        numbers.stream().parallel().close();
        
        numbers.parallelStream().close();
        
        Stream<Integer> myStream = Stream.of(1, 2, 3);
        
        myStream.parallel().close();
    }
    
}

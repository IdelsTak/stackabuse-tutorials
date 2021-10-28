/*
 * Copyright 2021
 */
package com.github.idelstak.streams.parallel;

import java.util.stream.Stream;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class IsParallelUse {

    public IsParallelUse() {
    }

    public void printToConsole(Stream<String> logs) {
//        logs.forEach(System.out::println);

        if (logs.isParallel()) {
            logs.forEachOrdered(System.out::println);
        } else { //if logs is sequential
            logs.forEach(System.out::println);
        }
    }
}

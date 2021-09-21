/*
 * Copyright 2021
 */
package com.github.idelstak.reduce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class MutableReduce {

    public List<Integer> getList() {
        Stream<Integer> numbersStream = Arrays.asList(12, 13, 14, 15, 16, 17)
                .stream();
        List<Integer> numbersList = numbersStream.reduce(
                //identity
                new ArrayList<>(),
                //accumulator
                (list, number) -> {
                    list.add(number);
                    return list;
                },
                //combiner
                (list1, list2) -> {
                    list1.addAll(list2);
                    return list1;
                }
        );

        return numbersList;
    }
}

/*
 * Copyright 2021
 */
package com.github.idelstak.flatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class TransformedStream {

    private final List<?> list1;
    private final List<?> list2;

    public TransformedStream(List<?> list1, List<?> list2) {
        this.list1 = new ArrayList<>(list1);
        this.list2 = new ArrayList<>(list2);
    }

    public static void main(String[] args) {
        List<?> l1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<?> l2 = Arrays.asList(7, 8, 9);
        
        TransformedStream ts = new TransformedStream(l1, l2);
        
        Stream<List<?>> s = ts.pairUp();
        
        s.forEach(System.out::println);    
    }

    public Stream<List<?>> pairUp() {
        return list1
                .stream()
                .flatMap(fromList1 -> {
                    return list2
                            .stream()
                            .map(fromList2 -> {
                                return Arrays.asList(fromList1, fromList2);
                            });
                });
    }
}

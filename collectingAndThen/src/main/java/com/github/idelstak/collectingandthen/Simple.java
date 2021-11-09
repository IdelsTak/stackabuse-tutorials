/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class Simple {

    public static void main(String[] args) {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList) //finisher
                );
        System.out.println(list.getClass());

        List<String> list2 = Stream.of("a", "b", "c", "d")
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(Function.identity(), s -> s + s),
                        map -> map.entrySet().stream()
                ))
                .map(Object::toString)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList));
        list2.forEach(System.out::println);

List<Integer> list1 = Stream.of(12, 13, 14, 15)
        .collect(
                //Supplier
                () -> new ArrayList<Integer>(),
                //Accumulator
                (l, e) -> l.add(e),
                //Combiner
                (l, ar) -> l.addAll(ar)
        );

List<Integer> collect = Stream.of(12, 13, 14, 15)
        .collect(
                Collectors.collectingAndThen(
                        toList(), 
                        Collections::unmodifiableList
                )
        );

        System.out.println(list1.getClass() + " " + collect.getClass());

        List<Integer> unmodifiable = unmodifiableList(list1);

        System.out.println(unmodifiable.getClass().getSimpleName());

    }
}

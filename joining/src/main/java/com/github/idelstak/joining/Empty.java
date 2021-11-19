/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class Empty {

  public static void main(String[] args) {
    Stream<Integer> numbers = Stream.of(2, 4, 6);
    Predicate<Integer> predicate = i -> i % 2 == 0;

    String collected = numbers
            .filter(predicate)
            .map(Object::toString)
            .collect(Collectors.joining(","));

    System.out.println(collected);
  }
}

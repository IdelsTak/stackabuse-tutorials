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

  private final Stream<Integer> numbers;
  private final Predicate<Integer> predicate;

  public Empty(Predicate<Integer> predicate) {
    this.predicate = predicate;
    this.numbers = Stream.of(2, 4, 6);
  }

  public static void main(String[] args) {
    System.out.println("Odd numbers: " + new Empty(i -> i % 2 != 0).getValue());
    System.out.println("Even numbers: " + new Empty(i -> i % 2 == 0).getValue());
  }

  public String getValue() {
    return numbers
            .filter(predicate)
            .map(Object::toString)
            .collect(Collectors.joining(","));
  }
}

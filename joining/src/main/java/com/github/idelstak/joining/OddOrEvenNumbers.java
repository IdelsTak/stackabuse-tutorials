/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining;

import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class OddOrEvenNumbers {

  private final IntStream numbers;
  private final IntPredicate predicate;

  public OddOrEvenNumbers(IntPredicate predicate, int[] numbers) {
    this.predicate = predicate;
    this.numbers = stream(numbers);
  }

  public static void main(String[] args) {
    IntPredicate oddPredicate = i -> i % 2 != 0;
    int[] arr = new int[]{1, 2, 3, 4};
    System.out.println(new OddOrEvenNumbers(oddPredicate, arr));

    IntPredicate evenPredicate = i -> i % 2 == 0;
    System.out.println(new OddOrEvenNumbers(evenPredicate, arr));

    arr = new int[]{1, 3, 5, 7};
    System.out.println(new OddOrEvenNumbers(evenPredicate, arr));
  }

  @Override
  public String toString() {
    return numbers
            .filter(predicate)
            .mapToObj(Integer::toString)
            .collect(Collectors.joining(","));
  }
}

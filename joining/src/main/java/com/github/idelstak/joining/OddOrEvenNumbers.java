/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class OddOrEvenNumbers {

  private final IntStream numbers;
  private final IntPredicate predicate;

  public OddOrEvenNumbers(IntPredicate predicate, int[] numbers) {
    this.predicate = predicate;
    this.numbers = Arrays.stream(numbers);
  }

  public static void main(String[] args) {
    IntPredicate oddPredicate = i -> i % 2 != 0;
    int[] arr = new int[]{1, 2, 3, 4};
    System.out.println("Odd numbers: " + new OddOrEvenNumbers(oddPredicate, arr).getValue());

    IntPredicate evenPredicate = i -> i % 2 == 0;
    System.out.println("Even numbers: " + new OddOrEvenNumbers(evenPredicate, arr).getValue());

    arr = new int[]{1, 3, 5, 7};
    System.out.println("Even numbers: " + new OddOrEvenNumbers(evenPredicate, arr).getValue());
  }

  public String getValue() {
    return numbers
            .filter(predicate)
            .mapToObj(Integer::toString)
            .collect(Collectors.joining(","));
  }
}

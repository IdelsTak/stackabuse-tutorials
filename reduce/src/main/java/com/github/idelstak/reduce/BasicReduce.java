/*
 * Copyright 2021
 */
package com.github.idelstak.reduce;

import java.util.Arrays;
import java.util.stream.IntStream;

/** @author Hiram K. <https://github.com/IdelsTak> */
public class BasicReduce {

  private final int[] values;

  public BasicReduce(int[] values) {
    this.values = values;
  }

  public int sum() {
    IntStream stream = Arrays.stream(values);
    return stream.reduce(0, (left, right) -> left + right);
  }
}

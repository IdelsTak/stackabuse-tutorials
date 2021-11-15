/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class CheckIfEmpty {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3);

    Boolean empty = list.stream()
            .collect(collectingAndThen(
                    toList(),
                    List::isEmpty
            ));
  }
}

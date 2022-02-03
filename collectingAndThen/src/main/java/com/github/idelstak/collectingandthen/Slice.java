/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** @author Hiram K. <https://github.com/IdelsTak> */
public class Slice {

  private final Stream<Integer> s;
  private final int from;
  private final int to;

  public Slice(Stream<Integer> s, int from, int to) {
    this.s = s;
    this.from = from;
    this.to = to;
  }

  public List<Integer> getList() {
    return s.collect(
        Collectors.collectingAndThen(
            Collectors.toList(),
            l -> {
              return l.stream().skip(from).limit(to - (from - 1)).collect(Collectors.toList());
            }));
  }
}

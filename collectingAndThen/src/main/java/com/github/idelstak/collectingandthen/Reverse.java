/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.reverse;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

/** @author Hiram K. <https://github.com/IdelsTak> */
public class Reverse {

  private final Stream<?> s;

  public Reverse(Stream<?> s) {
    this.s = s;
  }

  public List<?> getList() {
    return s.collect(
        collectingAndThen(
            toList(),
            l -> {
              reverse(l);
              return l;
            }));
  }
}

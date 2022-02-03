/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

/** @author Hiram K. <https://github.com/IdelsTak> */
public class Shuffle {

  private final Stream<?> stream;

  public Shuffle(Stream<?> stream) {
    this.stream = stream;
  }

  public List<?> getList() {
    return stream.collect(
        collectingAndThen(
            toList(),
            l -> {
              Collections.shuffle(l);
              return l;
            }));
  }
}

/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/** @author Hiram K. <https://github.com/IdelsTak> */
public class Immutable {

  private final Stream<Integer> stream;

  public Immutable(Stream<Integer> stream) {
    this.stream = stream;
  }

  public List<Integer> getList() {
    return stream.collect(collectingAndThen(toList(), Collections::unmodifiableList));
  }

  public Set<Integer> getSet() {
    return stream.collect(collectingAndThen(toSet(), Collections::unmodifiableSet));
  }

  public Map<Integer, Integer> getMap() {
    return stream
        .distinct()
        .collect(
            collectingAndThen(
                Collectors.toMap(Function.identity(), i -> (int) Math.pow(i, 2)),
                Collections::unmodifiableMap));
  }
}

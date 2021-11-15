/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class Singleton {

  private final Stream<?> stream;

  public Singleton(Stream<?> stream) {
    this.stream = stream;
  }

  public Set<?> getSingleton() {
    return stream.collect(collectingAndThen(
            toList(),
            l -> {
              if (l.size() > 1) {
                throw new IllegalArgumentException();
              } else {
                return l.isEmpty()
                ? Collections.emptySet()
                : Collections.singleton(l.get(0));
              }
            }
    ));
  }

}

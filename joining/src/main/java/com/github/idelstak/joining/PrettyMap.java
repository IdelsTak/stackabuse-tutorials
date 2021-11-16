/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining;

import static java.lang.System.lineSeparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collector;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class PrettyMap {

  public static void main(String[] args) {
    Map<String, Integer> cats = new HashMap<>();

    cats.put("Anne", 3);
    cats.put("Berty", 1);
    cats.put("Cecilia", 1);
    cats.put("Denny", 0);
    cats.put("Erica", 0);
    cats.put("Fiona", 2);

    String result = cats.entrySet()
            .stream()
            .collect(
                    collectingAndThen(
                            toMap(
                                    e -> e.getKey() + " has ",
                                    e -> (e.getValue() == 0 ? "no" : e.getValue()) + (e.getValue() <= 1 ? " cat" : " cats")
                            ),
                            m -> {
                              return m.entrySet()
                                      .stream()
                                      .map(e -> e.getKey() + e.getValue())
                                      .collect(joining(lineSeparator()));
                            }
                    )
            );

    System.out.println(result);
  }
}

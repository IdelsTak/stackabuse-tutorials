/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining.practice.grammar;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.joining;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class OxfordComma {

  private static final Collector<String, ?, List<String>> DOWNSTREAM = Collectors.toList();
  private static final Function<List<String>, String> FINISHER = list -> {
    String value = "[No words were provided]";                            //(1)

    if (list.size() == 1) {
      value = list.stream().collect(joining(""));                         //(2)
    } else if (list.size() == 2) {
      value = list.stream().collect(joining(" and "));                    //(3)
    } else if (list.size() > 2) {
      int lastIdx = list.size() - 1;
      String first = list.stream().limit(lastIdx).collect(joining(", ")); //(4)
      String last = list.get(lastIdx);                                    //(5)
      value = Stream.of(first, last).collect(joining(", and "));          //(6)
    }

    return value;
  };
  private final String[] words;

  public OxfordComma(String... words) {
    this.words = words;
  }

  public String generate() {
    return Arrays
            .stream(words)
            .collect(collectingAndThen(DOWNSTREAM, FINISHER));
  }

  public static void main(String[] args) {
    OxfordComma comma = new OxfordComma();
    System.out.println(comma.generate());

    comma = new OxfordComma("maroon");
    System.out.println(comma.generate());

    comma = new OxfordComma("maroon", "lavender");
    System.out.println(comma.generate());

    comma = new OxfordComma("maroon", "lavender", "olive");
    System.out.println(comma.generate());

    comma = new OxfordComma("maroon", "lavender", "olive", "silver", "turquoise");
    System.out.println(comma.generate());
  }
}

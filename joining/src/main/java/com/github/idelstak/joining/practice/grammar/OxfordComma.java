/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining.practice.grammar;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class OxfordComma {

  private final String[] words;

  public OxfordComma(String... words) {
    this.words = words;
  }

  public String generate() {
    Collector<String, ?, List<String>> downstream = toList();
    Function<List<String>, String> finisher = list -> {
      String value = "[No words were provided]";

      if (list.size() == 1) {
        value = list.stream().collect(joining(""));
      } else if (list.size() == 2) {
        value = list.stream().collect(joining(" and "));
      } else if (list.size() > 2) {
        int lastIdx = list.size() - 1;
        String first = list.stream().limit(lastIdx).collect(joining(", "));
        String last = list.get(lastIdx);
        value = Stream.of(first, last).collect(joining(", and "));
      }

      return value;
    };

    return Arrays
            .stream(words)
            .collect(collectingAndThen(downstream, finisher));
  }

  public static void main(String[] args) {
    OxfordComma comma = new OxfordComma("maroon", "lavender", "olive", "blue");

    System.out.println(comma.generate());
  }
}

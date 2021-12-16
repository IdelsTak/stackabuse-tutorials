/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining.practice.grammar;

import java.util.Arrays;
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
    return Arrays.stream(words)
            .collect(
                    collectingAndThen(
                            toList(),
                            l -> {
                              String value = "[No words were provided]";

                              if (l.size() == 1) {
                                value = l.stream().collect(joining(""));
                              } else if (l.size() == 2) {
                                value = l.stream().collect(joining(" and "));
                              } else if (l.size() > 2) {
                                int lastIdx = l.size() - 1;
                                String first = l.stream().limit(lastIdx).collect(joining(", "));
                                String last = l.get(lastIdx);
                                value = Stream.of(first, last).collect(joining(", and "));
                              }

                              return value;
                            }
                    ));
  }

  public static void main(String[] args) {
    OxfordComma comma = new OxfordComma("maroon", "lavender", "olive", "blue");
    
    System.out.println(comma.generate());
  }
}

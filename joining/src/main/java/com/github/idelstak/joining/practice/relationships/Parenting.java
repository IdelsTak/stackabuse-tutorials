/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining.practice.relationships;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.joining;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class Parenting {

  private final String parent;
  private final int numberOfChildren;

  public Parenting(String parent, int numberOfChildren) {
    this.parent = parent;
    this.numberOfChildren = numberOfChildren;
  }

  public String getParent() {
    return parent;
  }

  public int getNumberOfChildren() {
    return numberOfChildren;
  }

  public static void main(String[] args) {
    Stream<Parenting> parentingStream = Stream.of(
            new Parenting("Sabrina Gottlieb", 1),
            new Parenting("Jonna Kub", 3),
            new Parenting("Damion O'Reilly", 2),
            new Parenting("Anibal Botsford", 3),
            new Parenting("Jeffry Bayer", 0),
            new Parenting("Sherrill Boehm", 3),
            new Parenting("Betsy D'Amore", 0),
            new Parenting("Prince VonRueden", 0),
            new Parenting("Devona Beer", 4),
            new Parenting("Seth O'Keefe", 4)
    );
    Function<Parenting, String> keyMapper = p -> p.getParent() + " has ";
    Function<Parenting, String> valueMapper = p -> {
      int kids = p.getNumberOfChildren();
      String a = kids == 0 ? "no" : Integer.toString(kids);
      String b = kids <= 1 ? " child" : " children";
      return a + b;
    };
    Collector<Parenting, ?, Map<String, String>> downstream = Collectors.toMap(keyMapper, valueMapper);
    Function<Map<String, String>, String> finisher = map -> {
      return map
              .entrySet()
              .stream()
              .map(entry -> entry.getKey() + entry.getValue())
              .collect(joining(lineSeparator()));
    };

    String details = parentingStream.collect(collectingAndThen(downstream, finisher));

    System.out.println(details);
  }
}

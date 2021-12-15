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
public class Parenthood {

  private final String parent;
  private final int numberOfChildren;

  public Parenthood(String parent, int numberOfChildren) {
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
    Stream<Parenthood> stream = Stream.of(
            new Parenthood("Sabrina Gottlieb", 1),
            new Parenthood("Jonna Kub", 3),
            new Parenthood("Damion O'Reilly", 2),
            new Parenthood("Anibal Botsford", 3),
            new Parenthood("Jeffry Bayer", 0),
            new Parenthood("Sherrill Boehm", 3),
            new Parenthood("Betsy D'Amore", 0),
            new Parenthood("Prince VonRueden", 0),
            new Parenthood("Devona Beer", 4),
            new Parenthood("Seth O'Keefe", 4)
    );
    Function<Parenthood, String> keyMapper = ph -> ph.getParent() + " has ";
    Function<Parenthood, String> valueMapper = ph -> {
      int kids = ph.getNumberOfChildren();
      Object a = kids == 0 ? "no" : kids;
      String b = kids <= 1 ? " child" : " children";
      return a + b;
    };
    Collector<Parenthood, ?, Map<String, String>> downstream = Collectors.toMap(keyMapper, valueMapper);
    Function<Map<String, String>, String> finisher = map -> {
      return map
              .entrySet()
              .stream()
              .map(entry -> entry.getKey() + entry.getValue())
              .collect(joining(lineSeparator()));
    };

    String result = stream.collect(collectingAndThen(downstream, finisher));

    System.out.println(result);
  }
}

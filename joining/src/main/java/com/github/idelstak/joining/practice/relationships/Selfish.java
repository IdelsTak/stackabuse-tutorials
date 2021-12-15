/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining.practice.relationships;

import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class Selfish {

  private final String term;

  public Selfish(String term) {
    this.term = term;
  }

  @Override
  public String toString() {
    return term;
  }

  public static void main(String[] args) {
    Stream<Selfish> stream = Stream.of(
            new Selfish("Me"),
            new Selfish("Myself"),
            new Selfish("I")
    );

    String result = stream.collect(
            collectingAndThen(
                    toList(),
                    l -> {
                      int last = l.size() - 1;
                      if (last < 1) {
                        return l.stream().map(Object::toString).collect(joining(""));
                      } else if (last == 1) {
                        return l.stream().map(Object::toString).collect(joining(" and "));
                      } else {
                        String a = l.stream().map(Object::toString).limit(last).collect(joining(", "));
                        return a + ", and " + l.get(last).toString();
                      }
                    }
            ));

    System.out.println(result);
  }
}

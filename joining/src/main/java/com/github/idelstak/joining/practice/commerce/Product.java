/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining.practice.commerce;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class Product {

  private final String attribute;
  private final String material;
  private final String name;

  public Product(String attribute, String material, String name) {
    this.attribute = attribute;
    this.material = material;
    this.name = name;
  }

  @Override
  public String toString() {
    Predicate<String> nonNull = Objects::nonNull;
    Predicate<String> empty = String::isEmpty;
    Predicate<String> nonEmpty = empty.negate();
    Predicate<String> emptyTrimmed = s -> s.trim().isEmpty();
    Predicate<String> nonEmptyTrimmed = emptyTrimmed.negate();

    return Stream.of(attribute, material, name)
            .filter(nonNull.and(nonEmpty).and(nonEmptyTrimmed))
            .collect(joining(" "));
  }

  public static void main(String[] args) {

    String descriptions = Stream
            .of(
                    new Product("Heavy Duty", "Rubber", "Plate"),
                    new Product("Ergonomic", "Rubber", "Computer"),
                    new Product("Durable", "Cotton", "Bench"),
                    new Product("Intelligent", "Silk", "Lamp"),
                    new Product("Enormous", "Granite", "Shoes"),
                    new Product("Practical", "", "Watch"),
                    new Product("Gorgeous", null, "Bench"),
                    new Product("Ergonomic", "Paper", "Pants"),
                    new Product("Enormous", "Copper", "Bag"),
                    new Product("Fantastic", " ", "Keyboard")
            )
            .map(Product::toString)
            .collect(joining(lineSeparator()));

    System.out.println(descriptions);
  }
}

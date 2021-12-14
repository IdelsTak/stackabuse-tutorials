/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining.practice.commerce;

import java.util.Objects;
import java.util.StringJoiner;
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
    return Stream.of(attribute, material, name)
            .filter(Objects::nonNull)
            .collect(
                    () -> new StringJoiner("/").setEmptyValue("XXX"),
                    StringJoiner::add,
                    StringJoiner::merge
            )
            .toString();
  }

  public static void main(String[] args) {

    Stream<Product> products = Stream.of(
            new Product("Heavy Duty", "Rubber", "Plate"),
            new Product("Ergonomic", "Rubber", "Computer"),
            new Product("Durable", "Cotton", "Bench"),
            new Product("Intelligent", "Silk", "Lamp"),
            new Product("Enormous", "Granite", "Shoes"),
            new Product(null, null, null),
            new Product("Gorgeous", "", "Bench"),
            new Product("Ergonomic", "Paper", "Pants"),
            new Product("Enormous", "Copper", "Bag"),
            new Product("Fantastic", " ", "Keyboard")
    );

    String descriptions = products.map(Product::toString)
            .collect(joining(lineSeparator()));

    System.out.println(descriptions);
  }
}

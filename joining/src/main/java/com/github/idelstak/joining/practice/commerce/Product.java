/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining.practice.commerce;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class Product {

  private final String attribute;
  private final String material;
  private final String name;

  private static final Predicate<String> NON_NULL = Objects::nonNull;
  private static final Predicate<String> EMPTY = String::isEmpty;
  private static final Predicate<String> NON_EMPTY = EMPTY.negate();
  private static final Predicate<String> EMPTY_TRIMMED = s -> s.trim().isEmpty();
  private static final Predicate<String> NON_EMPTY_TRIMMED = EMPTY_TRIMMED.negate();

  public Product(String attribute, String material, String name) {
    this.attribute = attribute;
    this.material = material;
    this.name = name;
  }

  public String getAttribute() {
    return attribute;
  }

  public String getMaterial() {
    return material;
  }

  public String getName() {
    return name;
  }

//  @Override
//  public String toString() {
//    return Stream.of(this.getAttribute(), this.getMaterial(), this.getName())
//            .filter(NON_NULL.and(NON_EMPTY).and(NON_EMPTY_TRIMMED))
//            .collect(joining(" "));
//  }
  @Override
  public String toString() {
    return getDescription(this);
  }
//  @Override
//  public String toString() {
//    Stream<String> features = Stream.of(attribute, material, name);
//    return features.collect(joining(" "));
//  }

  public static void main(String[] args) {
    Stream<Product> products = Stream.of(
            new Product("Heavy Duty", "Rubber", "Plate"),
            new Product(" ", "Rubber", "Computer"),
            new Product("Durable", "Cotton", "Bench"),
            new Product("Intelligent", "Silk", "Lamp"),
            new Product("Enormous", "Granite", "Shoes"),
            new Product("Practical", "", "Watch"),
            new Product("Gorgeous", null, "Bench"),
            new Product("Ergonomic", "Paper", "Pants"),
            new Product("", "Copper", "Bag"),
            new Product("Fantastic", " ", "Keyboard")
    );

//    String descriptions = products
//            .map(Object::toString)
//            .collect(joining(System.lineSeparator()));
//
//    System.out.println(descriptions);
    String descriptions = products
            .map(Product::getDescription)
            .collect(joining(System.lineSeparator()));

    System.out.println(descriptions);
  }

  public static String getDescription(Product product) {
    return Stream.of(product.getAttribute(), product.getMaterial(), product.getName())
            .filter(NON_NULL.and(NON_EMPTY).and(NON_EMPTY_TRIMMED))
            .collect(joining(" "));
  }
}

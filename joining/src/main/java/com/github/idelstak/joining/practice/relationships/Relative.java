/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining.practice.relationships;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class Relative {

  private final String name;
  private final String relation;
  private final String profession;

  public Relative(String name, String relation, String profession) {
    this.name = name;
    this.relation = relation;
    this.profession = profession;
  }

  public String getName() {
    return name;
  }

  public String getRelation() {
    return relation;
  }

  public String getProfession() {
    return profession;
  }

  @Override
  public String toString() {
    return String.format("%s: %s--%s", name, relation, profession);
  }

  public static void main(String[] args) {
    Stream<Relative> relatives = Stream.of(
            new Relative("Manual Welch", "Granddaughter", "Accountant"),
            new Relative("Mariah Bergnaum", "Aunt", "Journalist"),
            new Relative("Ilona Waters", "Cousin", "Journalist"),
            new Relative("Emery Stamm", "Grandmother", "Dentist"),
            new Relative("Reyes King", "Cousin", "Taxi Driver"),
            new Relative("Ginger Jenkins", "Grandson", "Accountant"),
            new Relative("Pattie Hoeger", "Niece", "Photographer"),
            new Relative("Alexis Purdy", "Grandfather", "Translator"),
            new Relative("Shameka Lebsack", "Uncle", "Dietician")
    );
    Predicate<Relative> isAccountant = r -> r.getProfession().equals("Accountant");
    Function<Relative, String> toNameAndProfession = r -> r.getName() + ", " + r.getRelation();

    String accountants = relatives
            .filter(isAccountant)
            .map(toNameAndProfession)
            .collect(joining(System.lineSeparator()));

    System.out.println(accountants);
  }
}

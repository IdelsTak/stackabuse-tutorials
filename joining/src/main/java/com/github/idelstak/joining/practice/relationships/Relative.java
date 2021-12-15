/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining.practice.relationships;

import java.util.StringJoiner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.joining;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class Relative {

  private final String name;
  private final String relation;
  private final String profession;

  private static final Function<Relative, String> TO_NAME_AND_PROFESSION = r -> r.getName() + ", " + r.getRelation();

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

    Predicate<Relative> isTeacher = r -> r.getProfession().equals("Teacher");

    Collector<String, ?, String> stringJoin = Collector.of(
            () -> {
              return new StringJoiner(System.lineSeparator()).setEmptyValue("No relative");
            },
            StringJoiner::add,
            StringJoiner::merge,
            StringJoiner::toString
    );
    Collector<String, ?, String> collectAndThen = collectingAndThen(
            Collectors.toList(),
            l -> {
              return l.isEmpty()
              ? "No relative"
              : l.stream().collect(joining(System.lineSeparator()));
            }
    );

    System.out.println(relativesByProfession(relatives, isTeacher, collectAndThen));
    System.out.println(relativesByProfession(relatives, isTeacher, stringJoin));
  }

  public static String relativesByProfession(
          Stream<Relative> relatives,
          Predicate<Relative> byProfession,
          Collector<String, ?, String> collector) {

    return relatives
            .filter(byProfession)
            .map(TO_NAME_AND_PROFESSION)
            .collect(collector);
  }

}

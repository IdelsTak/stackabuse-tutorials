/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining.practice.names;

import com.github.javafaker.Bool;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.joining;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class WeddingPreparation {

  private static final List<Invitee> INVITEES = new ArrayList<>();

  static {
    Faker faker = new Faker();
    Bool bool = faker.bool();
    Name name = faker.name();
    int n = 10;

    for (int i = 0; i < n; i++) {
      if (i == n / 2) {
        INVITEES.add(
                new Invitee(
                        name.firstName(),
                        "Null",
                        true
                )
        );
      } else {
        INVITEES.add(
                new Invitee(
                        name.firstName(),
                        name.lastName(),
                        bool.bool() && bool.bool()
                )
        );
      }
    }

  }

  public static void main(String[] args) {
    String lastNames = INVITEES
            .stream()
            .map(Invitee::getLastName)
            .map(String::toLowerCase)
            .collect(joining(", "));

    System.out.println(lastNames);
  }
}

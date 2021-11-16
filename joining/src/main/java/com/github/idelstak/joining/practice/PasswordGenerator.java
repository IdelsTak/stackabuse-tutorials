/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class PasswordGenerator {

  private static final Character[] LETTERS;
  private static final Character[] NUMBERS;
  private static final Character[] LETTERS_AND_NUMBERS;

  static {
    LETTERS = IntStream.rangeClosed('a', 'z')
            .mapToObj(intVal -> (char) intVal)
            .toArray(Character[]::new);
    NUMBERS = IntStream.rangeClosed('0', '9')
            .mapToObj(intVal -> (char) intVal)
            .toArray(Character[]::new);

    LETTERS_AND_NUMBERS = Stream.concat(
            Arrays.stream(LETTERS),
            Arrays.stream(NUMBERS)
    ).toArray(Character[]::new);
  }

  public Stream<Character> randomChars() {
    Random random = new Random();
    return Arrays
            .stream(LETTERS_AND_NUMBERS)
            .collect(Collectors.collectingAndThen(
                    Collectors.mapping(
                            c -> {
                              if (random.nextBoolean() && random.nextBoolean()) {
                                c = Character.toUpperCase(c);
                              }
                              return c;
                            },
                            Collectors.toList()
                    ),
                    list -> {
                      Collections.shuffle(list);
                      return list.stream();
                    }
            ))
            .limit(10);

  }

  public String get() {
    return randomChars()
            .map(String::valueOf)
            .collect(Collectors.joining());
  }

  public static void main(String[] args) {
    PasswordGenerator generator = new PasswordGenerator();
    for (int i = 0; i < 10; i++) {
      System.out.println(generator.get());
    }
  }
}

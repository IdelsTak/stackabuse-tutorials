/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class PasswordGenerator {

  private static final Character[] CHARACTERS;
  private final int passwordLength;

  static {
    Stream<Character> letters = IntStream
            .rangeClosed('a', 'z')
            .mapToObj(intVal -> (char) intVal);
    Stream<Character> numbers = IntStream
            .rangeClosed('0', '9')
            .mapToObj(intVal -> (char) intVal);

    CHARACTERS = Stream
            .concat(letters, numbers)
            .toArray(Character[]::new);
  }

  public PasswordGenerator(int passwordLength) {
    this.passwordLength = passwordLength;
  }

  public Stream<Character> randomChars() {
    Random random = new Random();
    return Arrays
            .stream(CHARACTERS)
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
            .limit(passwordLength);

  }

  public String get() {
    return randomChars()
            .map(String::valueOf)
            .collect(Collectors.joining());
  }

  public static void main(String[] args) {
    PasswordGenerator generator = new PasswordGenerator(20);
    for (int i = 0; i < 10; i++) {
      System.out.println(generator.get());
    }
  }
}

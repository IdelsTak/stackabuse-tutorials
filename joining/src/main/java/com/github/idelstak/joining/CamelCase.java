/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class CamelCase {

  public static void main(String[] args) {
    String result = "some people said bad things";

    result = Stream.of(result.replaceAll("([\\p{Lu}]+)", "_$1")
            .split("[^\\pL0-9]"))
            .map(String::toLowerCase)
            .map(CamelCase::ucfirst)
            .collect(Collectors.joining(" "));

    System.out.println(result);
  }

  private static String ucfirst(String input) {
    return withFirst(input, first -> String.valueOf(Character.toUpperCase(first)));
  }

  private static String withFirst(String input, Function<Character, String> callback) {
    if (input == null) {
      return null;
    } else if (input.length() == 0) {
      return "";
    } else {
      return String.join("",
              callback.apply(input.charAt(0)),
              input.subSequence(1, input.length())
      );
    }
  }
}

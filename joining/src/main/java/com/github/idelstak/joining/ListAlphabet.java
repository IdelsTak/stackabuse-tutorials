/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.joining;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class ListAlphabet {

  private static final List<String> ALL_LETTERS = Arrays.asList(
          "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
          "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
          "u", "v", "w", "x", "y", "z"
  );

  public ListAlphabet() {
  }

  public String usingReduce() {
    return ALL_LETTERS
            .stream()
            .reduce(
                    "",
                    (t, u) -> t + u,
                    (t, u) -> t + u
            );
  }

  public String usingStringBuilder() {
    return ALL_LETTERS
            .stream()
            .reduce(
                    new StringBuilder(),
                    StringBuilder::append,
                    StringBuilder::append
            )
            .toString();
  }

  public String usingCollectorsJoining() {
    return ALL_LETTERS
            .stream()
            .collect(joining());
  }

}

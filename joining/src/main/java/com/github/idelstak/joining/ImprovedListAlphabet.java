/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class ImprovedListAlphabet {

  public ImprovedListAlphabet() {
  }

  public String usingIntStreamRangeClosed() {
    return IntStream.rangeClosed('a', 'z')
            .mapToObj(i -> (char) i)
            .map(Object::toString)
            .collect(joining());
  }
}

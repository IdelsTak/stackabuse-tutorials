/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen;

import java.util.List;
import java.util.stream.Stream;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class ReverseTest {

  public ReverseTest() {
  }

  @Test
  public void shouldReverseList() {
    Stream<Integer> s = Stream.of(1, 2, 3);
    Reverse r = new Reverse(s);
    List<?> l = r.getList();

    assertEquals("[3, 2, 1]", l.toString());
  }

}

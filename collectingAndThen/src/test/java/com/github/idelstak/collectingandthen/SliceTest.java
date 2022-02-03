/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** @author Hiram K. <https://github.com/IdelsTak> */
public class SliceTest {

  public SliceTest() {}

  @Test
  public void shouldSliceList() {
    Stream<Integer> s = IntStream.rangeClosed(0, 10).boxed();
    Slice slice = new Slice(s, 3, 7);
    List<Integer> l = slice.getList();

    assertEquals("[3, 4, 5, 6, 7]", l.toString());
  }
}

/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen;

import java.util.List;
import java.util.stream.Stream;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class ShuffleTest {

  public ShuffleTest() {
  }

  @Test
  public void shouldShuffleList() {
    Shuffle shuffle = new Shuffle(Stream.of(1, 2, 3));
    List<?> list = shuffle.getList();

    assertNotEquals("[1, 2, 3]", list.toString());
  }

}

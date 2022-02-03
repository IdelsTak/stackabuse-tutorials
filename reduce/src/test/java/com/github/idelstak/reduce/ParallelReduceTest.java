/*
 * Copyright 2021
 */
package com.github.idelstak.reduce;

import org.junit.Test;

import static java.lang.System.nanoTime;
import static java.lang.System.out;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/** @author Hiram K. <https://github.com/IdelsTak> */
public class ParallelReduceTest {

  public ParallelReduceTest() {}

  @Test
  public void rangeClosedShouldBeFasterThanIterate() {
    ParallelReduce pr = new ParallelReduce(1_000_000);

    long start = nanoTime();
    int iterateSum = pr.iterateSum();
    long iterateDuration = nanoTime() - start;

    out.printf("iterate sum duration: %d ms\n", iterateDuration / 1_000_000);
    out.printf("iterate sum: %d\n", iterateSum);

    start = nanoTime();
    int rangeSum = pr.rangeSum();
    long rangeDuration = nanoTime() - start;

    out.printf("range closed sum duration: %d ms\n", rangeDuration / 1_000_000);
    out.printf("range closed sum: %d\n", rangeSum);

    assertTrue(rangeDuration < iterateDuration);
    assertEquals(iterateSum, rangeSum);
  }
}

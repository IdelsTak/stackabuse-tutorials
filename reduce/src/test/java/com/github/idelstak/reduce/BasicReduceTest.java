/*
 * Copyright 2021
 */
package com.github.idelstak.reduce;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class BasicReduceTest {

    public BasicReduceTest() {
    }

    @Test
    public void shouldCalculateSum() {
        //Given
        int[] values = new int[]{11, 22, 33, 44, 55};
        BasicReduce basicReduce = new BasicReduce(values);
        //When
        int actual = basicReduce.sum();
        int expected = 165;
        //Then
        assertEquals(expected, actual);
    }

}

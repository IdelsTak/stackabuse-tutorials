/*
 * Copyright 2021
 */
package com.github.idelstak.flatmap;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class PascalsTriangle {

    private final int numberOfRows;

    public PascalsTriangle(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public static void main(String[] args) {
        PascalsTriangle pt = new PascalsTriangle(10);
        List<List<Integer>> vals = pt.generate();

        vals.stream()
                .forEach(System.out::println);
        
        Function<List<Integer>, IntStream> mapper = (List<Integer> list) -> IntStream.of(
                list.stream()
                        .mapToInt(Integer::intValue)
                        .sum()
        );

        int total = vals.stream()
                .flatMapToInt(mapper)
                .sum();

        System.out.println(total);

    }

    public List<List<Integer>> generate() {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numberOfRows; i++) {
            List<Integer> currentRow = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                currentRow.add((0 < j && j < i)
                        ? triangle.get(i - 1).get(j - 1)
                        + triangle.get(i - 1).get(j)
                        : 1);
            }
            triangle.add(currentRow);
        }

        return triangle;
    }
}

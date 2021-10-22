/*
 * Copyright 2021
 */
package com.github.idelstak.flatmap;

import java.util.Optional;
import java.util.function.Function;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class FlattenedOptional {

    private final Optional<Optional<Integer>> nestedOptional;

    public FlattenedOptional(Optional<Integer> optional) {
        this.nestedOptional = Optional.of(optional);
    }

    public static void main(String[] args) {
        FlattenedOptional fo = new FlattenedOptional(Optional.of(1));

        fo.flatten();
    }

    public void flatten() {
        nestedOptional
                .flatMap(Function.identity())
                .ifPresent(System.out::println);
    }

}

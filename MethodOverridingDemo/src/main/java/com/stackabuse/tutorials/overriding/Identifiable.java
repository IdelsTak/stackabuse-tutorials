/*
 * Copyright 2020.
 */
package com.stackabuse.tutorials.overriding;

import java.io.Serializable;

/**
 *
 * @author Hiram K. <hiram.kamau@outlook.com>
 * @param <T>
 */
public interface Identifiable<T extends Serializable> {

    T getId();

    class PrimaryKey implements Identifiable<Integer> {

        private final int value;

        PrimaryKey(int value) {
            this.value = value;
        }

        @Override
        public Integer getId() {
            return value;
        }

    }
}

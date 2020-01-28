/*
 * Copyright 2020.
 */
package com.stackabuse.tutorials.overriding;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author Hiram K. <hiram.kamau@outlook.com>
 */
public class PolymorphicAnimal {

    private static final Logger LOG = Logger.getLogger(PolymorphicAnimal.class.getName());

    public static void main(String[] args) {
        var dog = new Dog();
        var cat = new Cat();

        Stream.of(dog, cat).forEach(Animal::makeSound);
    }

    abstract class Animal {

        abstract void makeSound();
    }

    static class Dog extends Animal {

        @Override
        void makeSound() {
            LOG.log(Level.INFO, "Bark!");
        }

    }

    static class Cat extends Animal {

        @Override
        void makeSound() {
            LOG.log(Level.INFO, "Meow!");
        }

    }
}

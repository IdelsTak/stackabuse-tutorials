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
class PolymorphicAnimal {

    private static final Logger LOG = Logger.getLogger(PolymorphicAnimal.class.getName());

    public static void main(String[] args) {
        new PolymorphicAnimal().makeSoundTest();
    }

    private void makeSoundTest() {
        var dog = new Dog();
        var cat = new Cat();

        Stream.of(dog, cat).forEach(Animal::makeSound);
    }

    abstract class Animal {

        abstract void makeSound();
    }

    class Dog extends Animal {

        @Override
        void makeSound() {
            LOG.log(Level.INFO, "Bark!");
        }

    }

    class Cat extends Animal {

        @Override
        void makeSound() {
            LOG.log(Level.INFO, "Meow!");
        }

    }
}

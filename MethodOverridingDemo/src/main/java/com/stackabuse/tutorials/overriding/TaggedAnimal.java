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
public class TaggedAnimal {

    private static final Logger LOG = Logger.getLogger(TaggedAnimal.class.getName());

public static void main(String[] args) {
    var dog = new Dog();
    var cat = new Cat();

    Stream.of(dog, cat).forEach(animal -> makeSound(animal));
}

    static void makeSound(Object animal) {
        switch (animal.toString()) {
            case "Dog":
                LOG.log(Level.INFO, ((Dog) animal).bark());
                break;
            case "Cat":
                LOG.log(Level.INFO, ((Cat) animal).meow());
                break;
            default:
                throw new AssertionError(animal);
        }
    }

    static class Dog {

        String bark() {
            return "Bark!";
        }

        @Override
        public String toString() {
            return "Dog";
        }

    }

    static class Cat {

        String meow() {
            return "Meow!";
        }

        @Override
        public String toString() {
            return "Cat";
        }

    }

}

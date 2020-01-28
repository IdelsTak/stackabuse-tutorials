/*
 * Copyright 2020.
 */
package com.stackabuse.tutorials.overriding;

/**
 *
 * @author Hiram K. <hiram.kamau@outlook.com>
 */
abstract class Person {

    abstract String getName();

    abstract int getAge();
    
    class Customer extends Person{

        private final String name;
        private final int age;

        Customer(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        String getName() {
            return name;
        }

        @Override
        int getAge() {
            return age;
        }
        
    }
}

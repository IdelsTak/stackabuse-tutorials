/*
 * Copyright 2020.
 */
package com.stackabuse.tutorials.overriding.domain;

import java.util.Objects;

/**
 *
 * @author Hiram K. <hiram.kamau@outlook.com>
 */
public class Person {

    private String name;
    private Gender gender;

    /**
     * Creates a {@code Person} with a default name (i.e., "Unnamed") and
     * {@code Gender} (i.e., {@link Gender#UNKNOWN UNKNOWN}).
     */
    public Person() {
        this("Unnamed");
    }

    /**
     * Creates a {@code Person} with a name and default {@code Gender} (i.e,
     * {@link Gender#UNKNOWN UNKNOWN}).
     *
     * @param name
     */
    public Person(String name) {
        this(name, Gender.UNKNOWN);
    }

    /**
     * Creates a {@code Person} with a name and {@code Gender}.
     *
     * @param name
     * @param gender
     */
    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    /**
     * Get the value of gender
     *
     * @return the value of gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Set the value of gender
     *
     * @param gender new value of gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + Objects.hashCode(this.gender);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return this.gender == other.gender;
    }

    /**
     * Generate a human readable description of a {@code Person}.
     *
     * @return a description of a {@code Person}.
     */
    @Override
    public String toString() {
        return new StringBuilder("Person{name=")
                .append(name)
                .append(", gender=")
                .append(gender)
                .append('}')
                .toString();
    }

    /**
     * Declares the possible genders a {@code Person} may have.
     */
    public enum Gender {
        MALE, FEMALE, UNKNOWN;
    }

}

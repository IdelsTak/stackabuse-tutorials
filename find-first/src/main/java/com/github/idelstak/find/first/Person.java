/*
 * Copyright 2021
 */
package com.github.idelstak.find.first;

import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class Person implements Comparable<Person> {

    private final String firstName;
    private final String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.firstName);
        hash = 37 * hash + Objects.hashCode(this.lastName);
        return hash;
    }

    @Override
    @SuppressWarnings("AccessingNonPublicFieldOfAnotherObject")
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
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        return Objects.equals(this.lastName, other.lastName);
    }

    @Override
    public int compareTo(Person otherPerson) {
        return Comparator.comparing(Person::getFirstName)
                .thenComparing(Person::getLastName)
                .compare(this, otherPerson);
    }

    @Override
    public String toString() {
        return String.format("Person named: %s %s", firstName, lastName);
    }

}

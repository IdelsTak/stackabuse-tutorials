/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen.benchmark;

import java.util.Objects;

/** @author Hiram K. <https://github.com/IdelsTak> */
public class Person {

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
    int hash = 7;
    hash = 53 * hash + Objects.hashCode(this.firstName);
    hash = 53 * hash + Objects.hashCode(this.lastName);
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
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{firstName=").append(firstName);
    sb.append(", lastName=").append(lastName);
    sb.append('}');
    return sb.toString();
  }
}

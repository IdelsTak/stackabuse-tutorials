/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining.practice.film;

import java.util.Objects;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class Scene {

  private final String character;
  private final String location;

  public Scene(String character, String location) {
    this.character = character;
    this.location = location;
  }

  public String getCharacter() {
    return character;
  }

  public String getLocation() {
    return location;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 59 * hash + Objects.hashCode(this.character);
    hash = 59 * hash + Objects.hashCode(this.location);
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
    final Scene other = (Scene) obj;
    if (!Objects.equals(this.character, other.character)) {
      return false;
    }
    return Objects.equals(this.location, other.location);
  }

  @Override
  public String toString() {
    return location + ',' + character;
  }

}

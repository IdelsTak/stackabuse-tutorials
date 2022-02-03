/*
 * Copyright (C) 2022 Hiram K.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.idelstak.mapping.practice;

import java.util.Comparator;
import java.util.Objects;

/** @author Hiram K. */
public class Country implements Comparable<Country> {
  private final String code;
  private final String name;

  public Country(String code, String name) {
    this.code = code;
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 97 * hash + Objects.hashCode(this.code);
    hash = 97 * hash + Objects.hashCode(this.name);
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
    final Country other = (Country) obj;
    if (!Objects.equals(this.code, other.code)) {
      return false;
    }
    return Objects.equals(this.name, other.name);
  }

  @Override
  public int compareTo(Country otherCountry) {
    return Comparator.comparing(Country::getCode)
        .thenComparing(Country::getName)
        .compare(this, otherCountry);
  }

  @Override
  public String toString() {
    return String.format("%s - %s", code, name);
  }
}

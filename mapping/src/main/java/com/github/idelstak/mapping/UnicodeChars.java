/*
 * Copyright (C) 2022 Hiram K. <https://www.upwork.com/freelancers/~0157b88d591b73eb50>
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

package com.github.idelstak.mapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/** @author Hiram K. <https://www.upwork.com/freelancers/~0157b88d591b73eb50> */
public class UnicodeChars {

  private final int[] codes;

  public UnicodeChars(int... codes) {
    this.codes = codes;
  }

  public static void main(String[] args) {
    UnicodeChars chars = new UnicodeChars(97, 98, 99);
    List<Character> uppercaseChars = chars.toUppercase();

    System.out.println("Upper case chars: " + uppercaseChars);
  }

  private List<Character> toUppercase() {
    //    return mapToUppercase(IntStream.of(codes).mapToObj(i -> (char) i));
    return mappingToUppercase(IntStream.of(codes).mapToObj(i -> (char) i));
  }

  private List<Character> mapToUppercase(Stream<Character> characterStream) {
    return characterStream.map(Character::toUpperCase).collect(Collectors.toList());
  }

  private List<Character> mappingToUppercase(Stream<Character> characterStream) {
    return characterStream.collect(Collectors.mapping(Character::toUpperCase, Collectors.toList()));
  }
}

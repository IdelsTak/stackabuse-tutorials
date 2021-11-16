/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining.practice;

import com.github.javafaker.Faker;
import com.github.javafaker.Friends;
import com.github.javafaker.Internet;
import com.github.javafaker.Lorem;
import java.util.List;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class Scenes {

  public Scenes() {
    Faker faker = new Faker();
    Friends friends = faker.friends();

    for (int i = 0; i < 5; i++) {
      String character = friends.character();
      String location = friends.location();
      String quote = friends.quote();

//      System.out.printf("%s: location: %s; quote: %s\n", character, location, quote);
    }

    Lorem lorem = faker.lorem();

    for (int i = 0; i < 10; i++) {
      char character = lorem.character(false);

      System.out.print(character);
    }
  }

  public static void main(String[] args) {
    new Scenes();
  }
}

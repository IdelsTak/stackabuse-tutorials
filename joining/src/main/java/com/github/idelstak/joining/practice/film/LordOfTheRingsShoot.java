/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining.practice.film;

import com.github.javafaker.Faker;
import com.github.javafaker.LordOfTheRings;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class LordOfTheRingsShoot {

  private static final List<Scene> SCENES;

  static {
    SCENES = new ArrayList<>();
    Faker faker = new Faker();
    LordOfTheRings lotr = faker.lordOfTheRings();

    for (int i = 0; i < 1000; i++) {
      String character = lotr.character();
      String location = lotr.location();
      Scene scene = new Scene(character, location);
      SCENES.add(scene);
    }
  }

  public String charactersAt(String location) {
    return SCENES
            .stream()
            .distinct()
            .filter(scene -> scene.getLocation().equals(location))
            .map(Scene::getCharacter)
            .collect(joining(","));
  }

  public String numberOfCharactersByLocation() {
    Collector<Scene, Object, TreeMap<String, Long>> byLocation = (Collector<Scene, Object, TreeMap<String, Long>>) groupingBy(
            Scene::getLocation,
            TreeMap::new,
            Collectors.counting()
    );
    Function<TreeMap<String, Long>, String> asString = map -> {
      return map
              .entrySet()
              .stream()
              .map(Object::toString)
              .collect(joining("\n"));
    };
    return SCENES
            .stream()
            .distinct()
            .collect(collectingAndThen(byLocation, asString));
  }

  public static void main(String[] args) {
    LordOfTheRingsShoot shoot = new LordOfTheRingsShoot();

    System.out.println(shoot.charactersAt("Black Gate"));

    System.out.println(shoot.numberOfCharactersByLocation());
  }
}

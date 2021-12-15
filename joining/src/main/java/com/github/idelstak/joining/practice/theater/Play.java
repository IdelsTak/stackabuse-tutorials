/*
 * Copyright (C) 1021
 */
package com.github.idelstak.joining.practice.theater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class Play {

  private final List<String> lines = new ArrayList<>();

  public Play(List<String> lines) {
    this.lines.addAll(lines);
  }

  public List<String> getLines() {
    return Collections.unmodifiableList(lines);
  }

  public static void main(String[] args) {

    Play firstPlay = new Play(Arrays.asList(
            "Good Night, Good night! Parting is such sweet sorrow.",
            "For you and I are past our dancing days.",
            "It seems she hangs upon the cheek of night.",
            "O! she doth teach the torches to burn bright.",
            "O Romeo, Romeo! wherefore art thou Romeo?.",
            "Tempt not a desperate man.",
            "Not stepping o'er the bounds of modesty.",
            "It is the east, and Juliet is the sun."
    ));

    Play secondPlay = new Play(Arrays.asList(
            "It is the east, and Juliet is the sun.",
            "For you and I are past our dancing days.",
            "It seems she hangs upon the cheek of night.",
            "Wisely and slow; they stumble that run fast.",
            "O Romeo, Romeo! wherefore art thou Romeo?.",
            "See, how she leans her cheek upon her hand!",
            "What's in a name?",
            "Good Night, Good night! Parting is such sweet sorrow."
    ));

    System.out.println(matchingLines(firstPlay, secondPlay));

    System.out.println("\n");

    System.out.println(matchingLines(secondPlay, firstPlay));

    System.out.println("\n");

    System.out.println(newScript(firstPlay, secondPlay));
  }

  public static String matchingLines(Play play, Play otherPlay) {
    return play
            .getLines()
            .stream()
            .filter(line -> Collections.frequency(otherPlay.getLines(), line) >= 1)
            .collect(joining(System.lineSeparator()));
  }

public static String newScript(Play play, Play otherPlay) {
  Stream<String> combined = Stream.concat(
          play.getLines().stream(),
          otherPlay.getLines().stream()
  );

  return newScript(combined);
}

  public static String newScript(Stream<String> combinedStreams) {
    return combinedStreams
            .distinct() 
            .collect(joining(System.lineSeparator()));
  }

}

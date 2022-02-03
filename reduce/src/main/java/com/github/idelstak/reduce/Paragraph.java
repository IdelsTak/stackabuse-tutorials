/*
 * Copyright 2021
 */
package com.github.idelstak.reduce;

import java.util.ArrayList;
import java.util.List;

/** @author Hiram K. <https://github.com/IdelsTak> */
public class Paragraph {

  private final List<String> paragraph;

  public Paragraph(List<String> paragraph) {
    this.paragraph = new ArrayList<>(paragraph);
  }

  public int length() {
    int length =
        paragraph.stream()
            .reduce(
                0,
                (parLength, word) -> parLength + word.length(),
                (parLength, otherParLength) -> parLength + otherParLength);

    return length;
  }
}

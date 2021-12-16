/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining.benchmark;

import com.github.javafaker.Faker;
import com.github.javafaker.Lorem;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import static java.util.stream.Collectors.toList;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
@State(Scope.Benchmark)
public class ExecutionPlan {

  private List<String> words;
  @Param({"10", "100", "1000", "10000", "100000"})
  int count;

  @Setup(Level.Iteration)
  public void setup() {
    words = new ArrayList<>();

    Faker faker = new Faker();
    Lorem lorem = faker.lorem();

    words.addAll(
            Stream.generate(() -> lorem.word())
                    .limit(count)
                    .collect(toList())
    );
  }

  public List<String> getWords() {
    return words;
  }

}

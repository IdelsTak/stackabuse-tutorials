/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen.benchmark;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import java.util.ArrayList;
import java.util.List;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
@State(Scope.Benchmark)
public class ExecutionPlan {

  private List<Person> people;

  @Param({"10", "100", "1000", "10000", "100000"})
  int count;

  @Setup(Level.Iteration)
  public void setup() {
    people = new ArrayList<>();

    Name fakeName = new Faker().name();

    for (int i = 0; i < count; i++) {
      String firstName = fakeName.firstName();
      String lastName = fakeName.lastName();
      people.add(new Person(firstName, lastName));
    }
  }

  public List<Person> getPeople() {
    return people;
  }

}

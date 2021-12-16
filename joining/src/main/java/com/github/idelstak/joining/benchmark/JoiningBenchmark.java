/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining.benchmark;

import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import static java.util.concurrent.TimeUnit.SECONDS;
import static java.util.stream.Collectors.joining;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
@Warmup(iterations = 2)
@Measurement(iterations = 2, time = 1, timeUnit = SECONDS)
public class JoiningBenchmark {

  private static final String DELIMITER = ", ";

  @Fork(value = 1)
  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OutputTimeUnit(TimeUnit.SECONDS)
  public void withStringJoiner(ExecutionPlan plan, Blackhole blackhole) {
    StringJoiner joiner = new StringJoiner(DELIMITER);

    plan.getWords().stream().forEach(joiner::add);

    String asOneWord = joiner.toString();

    blackhole.consume(asOneWord);
  }

  @Fork(value = 1)
  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OutputTimeUnit(TimeUnit.SECONDS)
  public void withStringJoin(ExecutionPlan plan, Blackhole blackhole) {
    String asOneWord = String.join(DELIMITER, plan.getWords());

    blackhole.consume(asOneWord);
  }

  @Fork(value = 1)
  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OutputTimeUnit(TimeUnit.SECONDS)
  public void withStringBuilder(ExecutionPlan plan, Blackhole blackhole) {
    StringBuilder builder = new StringBuilder();
    List<String> words = plan.getWords();

    words.stream().forEach(w -> builder.append(w).append(DELIMITER));

    String asOneWord = builder.deleteCharAt(words.size() - 1).toString();

    blackhole.consume(asOneWord);
  }

  @Fork(value = 1)
  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OutputTimeUnit(TimeUnit.SECONDS)
  public void withJoining(ExecutionPlan plan, Blackhole blackhole) {
    String asOneWord = plan.getWords().stream().collect(joining(DELIMITER));

    blackhole.consume(asOneWord);
  }
}

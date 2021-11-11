/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen.benchmark;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import static java.util.Comparator.comparing;
import static java.util.concurrent.TimeUnit.SECONDS;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.maxBy;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
@Warmup(iterations = 2)
@Measurement(iterations = 2, time = 1, timeUnit = SECONDS)
public class CollectingAndThenBenchmark {

    @Fork(value = 1)
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void withoutCollectingAndThen(ExecutionPlan plan, Blackhole blackhole) {
        List<Person> people = plan.getPeople();

        String longestName = people.stream()
                .map(Person::getFirstName)
                .sorted(comparing(String::length).reversed())
                .findFirst()
                .orElse("?");

        blackhole.consume(longestName);
    }

    @Fork(value = 1)
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void withCollectingAndThen(ExecutionPlan plan, Blackhole blackhole) {
        List<Person> people = plan.getPeople();

        String longestName = people.stream()
                .map(Person::getFirstName)
                .collect(
                        collectingAndThen(
                                maxBy(comparing(String::length)),
                                s -> s.orElse("?")
                        )
                );

        blackhole.consume(longestName);
    }
}
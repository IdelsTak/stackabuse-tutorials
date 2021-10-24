/*
 * Copyright 2021
 */
package com.github.idelstak.streams.parallel;

import java.util.concurrent.ExecutorService;
import java.util.stream.Stream;

import static java.lang.Runtime.getRuntime;
import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class SumUtils {

    private final long n;
    private long result;

    public SumUtils(long n) {
        this.n = n;
        this.result = 0;
    }

    public static void main(String[] args) {
        SumUtils utils = new SumUtils(1_000);

        System.out.println("Sum for loop: " + utils.sumUsingClassicForLoop());

        utils = new SumUtils(10);

        System.out.println("Sum threading: " + utils.sumUsingThreading());
    }

    public long sumUsingClassicForLoop() {
        for (long i = 1L; i <= n; i++) {
            result += i;
        }

        return result;
    }

    public long sumUsingThreading() {
        Runtime runtime = getRuntime();
        int nThreads = runtime.availableProcessors();

        ExecutorService es = newFixedThreadPool(nThreads);

        try {
            for (long i = 1L; i <= n; i++) {
                long toAdd = i;
                es.execute(() -> result += toAdd);
            }
        } catch (Exception e) {
            System.out.println("Error occured");
        } finally {
            es.shutdown();
        }

        return result;
    }

    public long sumUsingParallel() {
        return Stream.iterate(1L, val -> val + 1L)
                .limit(n)
                .parallel()
                .reduce(0L, (val1, val2) -> Long.sum(val1, val2));
    }
}

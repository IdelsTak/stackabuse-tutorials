/*
 * Copyright 2021
 */
package com.github.idelstak.streams.parallel;

import java.util.concurrent.ExecutorService;
import java.util.stream.LongStream;

import static java.lang.Runtime.getRuntime;
import static java.lang.System.out;
import static java.lang.Thread.currentThread;
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
        SumUtils utils = new SumUtils(3);

//        System.out.println("Sum for loop: " + utils.sumUsingClassicForLoop());
//
//        utils = new SumUtils(10);
//
//        System.out.println("Sum threading: " + utils.sumUsingThreading());
        System.out.println("Sum parallel: " + utils.sumUsingParallel());
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
        return LongStream.rangeClosed(1L, 10)
                .parallel()
                .peek(this::printThreadName)
                .reduce(0L, this::printSum);
    }

    private long printSum(long a, long b) {
        long sum = a + b;
        String name = currentThread().getName();
        
        out.printf("%s has: %d; plus: %d; result: %d\n", name, a, b, sum);
        return sum;
    }

    private void printThreadName(long a) {
        String name = currentThread().getName();
        out.println(name + " offers:" + a);
    }
}

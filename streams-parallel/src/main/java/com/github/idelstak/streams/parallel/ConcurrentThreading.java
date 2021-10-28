/*
 * Copyright 2021
 */
package com.github.idelstak.streams.parallel;

import static java.lang.System.out;
import static java.lang.Thread.currentThread;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class ConcurrentThreading {

    public ConcurrentThreading() {
    }

    public static void main(String[] args) {
        new ConcurrentThreading().startThreads();
    }

    public void startThreads() {
        StringBuffer sb = new StringBuffer("hello world");

        Thread t1 = new Thread(() -> {
            String tName = currentThread().getName();
            out.printf("before running %s: %s\n", tName, sb);

            if (sb.length() > 0) {
                int idx = sb.length() - 1;
                char c = sb.charAt(idx);
                sb.deleteCharAt(idx);

                out.printf("on running: %s; remove %s\n", tName, c);
            }

            out.printf("after running %s: %s\n", tName, sb);
        }, "thread-1");


        Thread t2 = new Thread(() -> {
            String tName = currentThread().getName();
            out.printf("before running %s: %s\n", tName, sb);

            if (sb.length() > 0) {
                int idx = sb.length() - 1;
                char c = sb.charAt(idx);
                sb.deleteCharAt(idx);

                out.printf("on running: %s; remove %s\n", tName, c);
            }

            out.printf("after running %s: %s\n", tName, sb);
        }, "thread-2");

        t1.start();
        t2.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            //
        }

        out.printf("after all runs: %s\n", sb);
    }

}

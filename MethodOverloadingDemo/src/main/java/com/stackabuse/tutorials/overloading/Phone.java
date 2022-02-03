/*
 * Copyright 2020.
 */
package com.stackabuse.tutorials.overloading;

/** @author Hiram K. <hiram.kamau@outlook.com> */
public class Phone {

  public static void main(String[] args) {
    setNumber(123);
  }

  public static void setNumber(Integer number) {
    System.out.println("Set number of type Integer");
  }

  public static void setNumber(Integer... number) {
    System.out.println("Set number of type Integer varargs");
  }

  public static void setNumber(int number) {
    System.out.println("Set number of type int");
  }

  public static void setNumber(int... number) {
    System.out.println("Set number of type int varargs");
  }

  public static void setNumber(long number) {
    System.out.println("Set number of type long");
  }

  public static void setNumber(Object number) {
    System.out.println("Set number of type Object");
  }
}

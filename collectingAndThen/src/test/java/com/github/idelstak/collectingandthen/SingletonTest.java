/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen;

import java.util.Set;
import java.util.stream.Stream;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/** @author Hiram K. <https://github.com/IdelsTak> */
public class SingletonTest {

  public SingletonTest() {}

  @Test
  @SuppressWarnings("ThrowableResultIgnored")
  public void shouldCreateSingleton() {
    Singleton s1 = new Singleton(Stream.of(1, 2));
    assertThrows(RuntimeException.class, () -> s1.getSingleton());

    Singleton s2 = new Singleton(Stream.empty());
    Set<?> singleton = s2.getSingleton();
    assertEquals("[]", singleton.toString());

    Singleton s3 = new Singleton(Stream.of(1));
    singleton = s3.getSingleton();
    assertEquals("[1]", singleton.toString());
  }
}

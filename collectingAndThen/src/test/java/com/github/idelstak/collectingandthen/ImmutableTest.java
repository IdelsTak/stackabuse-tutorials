/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class ImmutableTest {

  public ImmutableTest() {
  }

  @Test
  @SuppressWarnings("ThrowableResultIgnored")
  public void listShouldBeImmutable() {
    Immutable i = new Immutable(Stream.of(1, 2, 3));
    List<Integer> l = i.getList();

    assertEquals("[1, 2, 3]", l.toString());
    assertEquals("UnmodifiableRandomAccessList", l.getClass()
            .getSimpleName());
    assertThrows(UnsupportedOperationException.class, () -> l.add(4));
  }

  @Test
  @SuppressWarnings("ThrowableResultIgnored")
  public void setShouldBeImmutable() {
    Immutable i = new Immutable(Stream.of(1, 2, 2));
    Set<Integer> set = i.getSet();

    assertEquals("[1, 2]", set.toString());
    assertEquals("UnmodifiableSet", set.getClass().getSimpleName());
    assertThrows(UnsupportedOperationException.class, () -> set.add(3));
  }

//    @Test
  @SuppressWarnings("ThrowableResultIgnored")
  public void mapShouldHaveDistinctEntries() {
    Stream<Integer> s = Stream.of(2, 3, 4, 4);
    Immutable i = new Immutable(s);

    assertThrows(
            IllegalStateException.class,
            () -> i.getMap()
    );
  }

  @Test
  @SuppressWarnings("ThrowableResultIgnored")
  public void mapShouldBeImmutable() {
    Stream<Integer> s = Stream.of(2, 3, 4, 4);
    Immutable i = new Immutable(s);
    Map<Integer, Integer> m = i.getMap();

    assertEquals("{2=4, 3=9, 4=16}", m.toString());
    assertEquals("UnmodifiableMap", m.getClass().getSimpleName());
    assertThrows(UnsupportedOperationException.class, () -> m.put(5, 25));
  }

}

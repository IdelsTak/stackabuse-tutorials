/*
 * Copyright 2021
 */
package com.github.idelstak.find.first;

import java.util.stream.Stream;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class FindTests {

    public static void main(String[] args) {
        Stream<Person> people = Stream.of(
                new Person("Lailah", "Glass"),
                new Person("Juliette", "Cross"),
                new Person("Sawyer", "Bonilla"),
                new Person("Madilynn", "Villa"),
                new Person("Nia", "Nolan"),
                new Person("Chace", "Simmons"),
                new Person("Ari", "Patrick"),
                new Person("Luz", "Gallegos"),
                new Person("Odin", "Buckley"),
                new Person("Paisley", "Chen")
        );

//        people
        //                .sorted()
        //                .sorted((o1, o2) -> {
        //                    return Comparator.comparing(Person::getFirstName).reversed().compare(o1, o2);
        //                })
//                .peek(person -> System.out
//                .printf("Traversing stream with %s\n", person))
//                .filter(FindTests::isFirstNameLong)
        //                .peek(person -> System.out.printf("Filtered stream with %s\n", person))
//                .findFirst()
//                .ifPresentOrElse(
//                        System.out::println,
//                        () -> System.out.println("No person was found")
//                );
        people
                //                .sorted((person1, person2) -> Comparator.comparing(Person::getFirstName)
                //                .reversed()
                //                .compare(person1, person2))
                .parallel()
                .peek(person -> System.out
                .printf("Traversing stream with %s\n", person))
                .filter(FindTests::isFirstNameLong)
                .findAny()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("No person was found")
                );

    }

    private static boolean isFirstNameLong(Person person) {
        return person.getFirstName().length() > 7;
    }

}

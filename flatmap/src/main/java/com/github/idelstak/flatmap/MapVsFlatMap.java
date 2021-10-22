/*
 * Copyright 2021
 */
package com.github.idelstak.flatmap;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class MapVsFlatMap {

    private final Stream<String> words;

    public MapVsFlatMap(Stream<String> words) {
        this.words = words;
    }

    public static void main(String[] args) {
//        Stream<String> loremIpsum = Stream
//                .of("lorem", "ipsum", "dolor", "sit", "amet");
//        MapVsFlatMap mapVsFlatMap = new MapVsFlatMap(loremIpsum);
//
//        mapVsFlatMap.doMap()
//                .forEach(
//                        stream -> stream.forEach(
//                                character -> System.out.print(character)
//                        )
//                );
//        mapVsFlatMap.doMap();
        //Should re-instantiate the class
        //because streams are not re-usable
//        loremIpsum = Stream.of("lorem", "ipsum", "dolor", "sit", "amet");
//        mapVsFlatMap = new MapVsFlatMap(loremIpsum);
//
//        System.out.println(mapVsFlatMap.doFlatMap());

        long limit = 15;

        IntStream is = IntStream.range(0, Integer.MAX_VALUE)
                .flatMap(i -> IntStream.range(0, i))
                .limit(limit);
        
//        is.forEach(val -> System.out.print(val));

    }

    private void doMap() {
        Function<String, IntStream> toIntStream = word -> word.chars();
        Function<IntStream, Stream<Character>> toCharsStream = new Function<IntStream, Stream<Character>>() {
            @Override
            public Stream<Character> apply(IntStream intStream) {
                return intStream.mapToObj(new IntFunction<Character>() {
                    @Override
                    public Character apply(int intVal) {
                        return (char) intVal;
                    }
                });
            }
        };

        words
                .map(toIntStream.andThen(toCharsStream))
                .peek(s -> System.out.println(s.collect(Collectors.toList())))
                .close();
    }

    private List<Character> doFlatMap() {
        return words
                .map(word -> word.chars())
                .flatMap(intStream -> intStream.mapToObj(i -> (char) i))
                .collect(Collectors.toList());
    }

}

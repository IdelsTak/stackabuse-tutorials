/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen.practice;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import org.junit.BeforeClass;
import org.junit.Test;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class StatsSourceTest {

    private static final StatsSource SRC = new StatsSource();
    private static List<CountryStats> stats;
    private Supplier<RuntimeException> exc = RuntimeException::new;

    @BeforeClass
    public static void loadStats() {
        stats = SRC.getStats();
    }

    @Test
    public void shouldLoadManyStats() {
        assertEquals(6468, stats.size());
    }

    @Test
    public void shouldGroupByCountry() {
        Map<String, List<CountryStats>> result = stats.stream()
                .collect(
                        groupingBy(
                                CountryStats::getCountry,
                                toList()
                        )
                );

        result.entrySet()
                .stream()
                .sorted(comparing(Entry::getKey))
                .limit(2)
                .forEach(entry -> {
                    entry.getValue()
                            .stream()
                            .sorted(comparing(CountryStats::getYear))
                            .forEach(stat -> {
//                                System.out.printf("%s, %s: %.3f\n", entry
//                                        .getKey(), stat.getYear(), stat
//                                        .getUnderFive().getMortality());
                            });
                });

        Map<String, Optional<CountryStats>> result2 = stats.stream()
                .collect(
                        groupingBy(
                                CountryStats::getCountry,
                                maxBy(comparing(CountryStats::getUnderFive))
                        )
                );

        result2.entrySet()
                .stream()
                .sorted(comparing(Entry::getKey))
                .limit(2)
                .forEach(entry -> {
                    CountryStats stat = entry.getValue().orElseThrow(exc);
                    System.out.printf(
                            "%s, %s: %.3f\n",
                            entry.getKey(),
                            stat.getYear(),
                            stat.getUnderFive().getMortality());
                });
    }

    @Test
    public void shouldCreateSingleGroup() {
        Map<String, String> result = stats.stream()
                .collect(groupingBy(CountryStats::getCountry,
                        TreeMap::new,
                        collectingAndThen(maxBy(comparing(CountryStats::getUnderFive)),
                                s -> s
                                        .orElseThrow(exc)
                                        .getYear()
                        )
                )
                );

        System.out.println(result);
    }

    @Test
    public void shouldCreateMultiLevelGroup() {
        Map<String, Map<String, String>> result = stats.stream()
                .collect(groupingBy(CountryStats::getCountry,
                        TreeMap::new,
                        groupingBy(CountryStats::getYear,
                                TreeMap::new,
                                collectingAndThen(maxBy(comparing(CountryStats::getHighest)),
                                        s -> s
                                                .orElseThrow(exc)
                                                .getHighest().getAgeGroup()
                                )
                        )
                )
                );

        System.out.println(result);
    }

    @Test
    public void shouldCreatePartition() {
        Predicate<CountryStats> pr = cs -> cs.getHighest().getMortality()
                .doubleValue() > 100000;
        Collector<CountryStats, ?, Optional<CountryStats>> maxBy = maxBy(comparing(CountryStats::getHighest));
        
        Map<Boolean, String> result = stats.stream()
                .collect(partitioningBy(pr,
                        collectingAndThen(maxBy,
                                s -> s
                                        .orElseThrow(exc)
                                        .toString()
                        )
                )
                );
        System.out.println(result);
    }

}

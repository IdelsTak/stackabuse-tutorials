/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen.practice;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.BeforeClass;
import org.junit.Test;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.partitioningBy;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class StatsCSVTest {

    private static final StatsCSV SCSV = new StatsCSV();
    private static List<CountryStats> stats;

    @BeforeClass
    public static void loadStats() {
        stats = SCSV.getStats();
    }

    @Test
    public void shouldLoadManyStats() {
        assertEquals(6468, stats.size());
    }

    @Test
    public void shouldSingleGroup() {
        Map<String, String> result = stats.stream()
                .collect(
                        groupingBy(
                                CountryStats::getCountry,
                                TreeMap::new,
                                collectingAndThen(
                                        maxBy(comparing(CountryStats::getUnderFive)),
                                        s -> s
                                                .orElseThrow(RuntimeException::new)
                                                .getYear()
                                )
                        )
                );

        System.out.println(result);
    }

    @Test
    public void shouldMultiGroup() {
        Map<String, Map<String, String>> result = stats.stream()
                .collect(
                        groupingBy(
                                CountryStats::getCountry,
                                groupingBy(
                                        CountryStats::getYear,
                                        TreeMap::new,
                                        collectingAndThen(
                                                maxBy(comparing(CountryStats::getHighest)),
                                                s -> s
                                                        .orElseThrow(RuntimeException::new)
                                                        .getHighest().getAgeGroup()
                                        )
                                )
                        )
                );

        System.out.println(result);
    }

    @Test
    public void shouldPartition() {
        Map<Boolean, String> result = stats.stream()
                .collect(
                        partitioningBy(
                                cs -> cs.getHighest().getMortality()
                                        .doubleValue() > 1000,
                                collectingAndThen(
                                        minBy(comparing(CountryStats::getHighest)),
                                        s -> s
                                                .orElseThrow(RuntimeException::new)
                                                .toString()
                                )
                        )
                );
        System.out.println(result);
    }

}

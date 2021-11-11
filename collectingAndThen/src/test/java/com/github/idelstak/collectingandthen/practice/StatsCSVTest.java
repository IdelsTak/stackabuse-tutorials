/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen.practice;

import java.util.List;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
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
    public void shouldGroupByYearWithHighestUnderFiveYearsMortality() {
        Map<String, String> result = stats.stream()
                .collect(
                        groupingBy(
                                CountryStats::getCountry,
                                collectingAndThen(
                                        maxBy(comparing(CountryStats::getUnderFive)),
                                        s -> s
                                                .orElseThrow(RuntimeException::new)
                                                .getYear()
                                )
                        )
                );

        System.out.println(result);
        System.out.println(result.size());
    }
    
    @Test
    public void shouldPartition() {
        
    }

}

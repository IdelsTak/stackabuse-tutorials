/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen.practice;

import com.github.idelstak.collectingandthen.practice.CountryStats.Mortality;
import java.math.BigDecimal;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.maxBy;

/** @author Hiram K. <https://github.com/IdelsTak> */
public class CountryStats implements Comparable<CountryStats> {

  private final String country;
  private final String year;
  private final Mortality underFive;
  private final Mortality seventyPlus;
  private final Mortality fiftyToSixtyNine;
  private final Mortality fiveToFourteen;
  private final Mortality fifteenToFourtyNine;

  public CountryStats(
      String country,
      String code,
      String year,
      BigDecimal underFive,
      BigDecimal seventyPlus,
      BigDecimal fiftyToSixtyNine,
      BigDecimal fiveToFourteen,
      BigDecimal fifteenToFourtyNine) {
    this.country = country;
    this.year = year;
    this.underFive = new Mortality("Under 5 yrs", underFive);
    this.seventyPlus = new Mortality("Over 70 yrs", seventyPlus);
    this.fiftyToSixtyNine = new Mortality("Between 50 and 69 yrs", fiftyToSixtyNine);
    this.fiveToFourteen = new Mortality("Between 5 and 14 yrs", fiveToFourteen);
    this.fifteenToFourtyNine = new Mortality("Between 15 and 49 yrs", fifteenToFourtyNine);
  }

  public String getCountry() {
    return country;
  }

  public String getYear() {
    return year;
  }

  public Mortality getUnderFive() {
    return underFive;
  }

  public Mortality getHighest() {
    Stream<Mortality> stream =
        Stream.of(underFive, fiveToFourteen, fifteenToFourtyNine, fiftyToSixtyNine, seventyPlus);

    Mortality highestMortality =
        stream.collect(
            collectingAndThen(
                maxBy(comparing(Mortality::getMortality)),
                m -> m.orElseThrow(RuntimeException::new)));

    return highestMortality;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{country/region=").append(country);
    sb.append(", year=").append(year);
    sb.append(", highest mortality=").append(getHighest());
    sb.append('}');
    return sb.toString();
  }

  @Override
  public int compareTo(CountryStats other) {
    return comparing(CountryStats::getUnderFive).compare(this, other);
  }

  public class Mortality implements Comparable<Mortality> {

    private final String ageGroup;
    private final BigDecimal mortality;

    public Mortality(String ageGroup, BigDecimal mortality) {
      this.ageGroup = ageGroup;
      this.mortality = mortality;
    }

    public String getAgeGroup() {
      return ageGroup;
    }

    public BigDecimal getMortality() {
      return mortality;
    }

    @Override
    public String toString() {
      return "{ageGroup=" + ageGroup + ", rate=" + mortality + '}';
    }

    @Override
    public int compareTo(Mortality otherMortality) {
      return comparing(Mortality::getMortality).compare(this, otherMortality);
    }
  }
}

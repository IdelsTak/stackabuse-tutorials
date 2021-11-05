/*
 * Copyright 2021
 */
package com.github.idelstak.collectingandthen;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class DeathStats {
    private final String country;
    private final String code;
    private final String year;
    private final int underFive;
    private final int seventyPlus;
    private final int fiftyToSixtyNine;
    private final int fiveToFourteen;
    private final int fifteenToFourtyNine;

    public DeathStats(String country, String code, String year, int underFive, int seventyPlus, int fiftyToSixtyNine, int fiveToFourteen, int fifteenToFourtyNine) {
        this.country = country;
        this.code = code;
        this.year = year;
        this.underFive = underFive;
        this.seventyPlus = seventyPlus;
        this.fiftyToSixtyNine = fiftyToSixtyNine;
        this.fiveToFourteen = fiveToFourteen;
        this.fifteenToFourtyNine = fifteenToFourtyNine;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{country/region=").append(country);
//        sb.append(", code=").append(code);
        sb.append(", year=").append(year);
        sb.append(", (< 5 yrs)=").append(underFive);
        sb.append(", (5 - 14 yrs)=").append(fiveToFourteen);
        sb.append(", (15 - 49 yrs)=").append(fifteenToFourtyNine);
        sb.append(", (50 - 69 yrs)=").append(fiftyToSixtyNine);
        sb.append(", (70+ yrs)=").append(seventyPlus);
        sb.append('}');
        return sb.toString();
    }
    
}

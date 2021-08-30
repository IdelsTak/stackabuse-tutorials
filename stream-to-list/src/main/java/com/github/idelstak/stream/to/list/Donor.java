/*
 * Copyright 2021
 */
package com.github.idelstak.stream.to.list;

import java.util.Comparator;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class Donor implements Comparable<Donor> {

    private final String name;
    private final String bloodGroup;
    private final int amountDonated;

    public Donor(String name, String bloodGroup, int amountDonated) {
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.amountDonated = amountDonated;
    }

    public String getName() {
        return name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public int getAmountDonated() {
        return amountDonated;
    }

    @Override
    public int compareTo(Donor otherDonor) {
        return Comparator.comparing(Donor::getName)
                .thenComparing(Donor::getBloodGroup)
                .thenComparingInt(Donor::getAmountDonated)
                .compare(this, otherDonor);
    }

}

/*
 * Copyright 2020.
 */
package com.stackabuse.tutorials.overloading;

/**
 *
 * @author Hiram K. <hiram.kamau@outlook.com>
 */
public class Address {

    private int id;
    private String details;

    public Address() {
        this.details = String.format(
                "%s, %s \n%s, %s",
                new Object[]{
                    "[Unknown Street]",
                    "[Unknown City]",
                    "[Unknown State]",
                    "[Unknown Zip]"});
    }

    public int getId() {
        return id;
    }

    public void setDetails(
            String line1,
            String line2) {

        setDetails(line1, line2, "[Unknown Zip]");
    }

    public void setDetails(
            String line1,
            String line2,
            String zip) {

        setDetails(line1, line2, "[Unknown State]", zip);
    }

    public void setDetails(
            String line1,
            String line2,
            int zipCode) {

        setDetails(line1, line2, "[Unknown State]", Integer.toString(zipCode));
    }

    public void setDetails(
            String line1,
            String line2,
            String state,
            String zip) {

        String allDetails = String.format(
                "%s, %s \n%s, %s",
                new Object[]{
                    line1,
                    line2,
                    state,
                    zip});

        setDetails(allDetails);
    }

    public void setDetails(String... details) {
        
    }
    
    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return details;
    }

}

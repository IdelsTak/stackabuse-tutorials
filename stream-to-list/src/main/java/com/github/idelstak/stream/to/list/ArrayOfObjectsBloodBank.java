/*
 * Copyright 2021
 */
package com.github.idelstak.stream.to.list;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class ArrayOfObjectsBloodBank extends AbstractBloodBank {

    @Override
    public List<String> getAvailableTypes() {
        Object[] bloodGroupObjects = donors.stream()
                .map(Donor::getBloodGroup)
                .toArray();

        String[] bloodGroups = new String[bloodGroupObjects.length];

        for (int i = 0; i < bloodGroupObjects.length; i++) {
            Object bloodGroupObject = bloodGroupObjects[i];

            bloodGroups[i] = String.class.cast(bloodGroupObject);
        }

        return Arrays.asList(bloodGroups);
    }

}

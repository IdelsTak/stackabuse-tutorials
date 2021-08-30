/*
 * Copyright 2021
 */
package com.github.idelstak.stream.to.list;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class StreamReduceBloodBank extends AbstractBloodBank {

    @Override
    public List<String> getAvailableTypes() {
        return donors.stream()
                .map(Donor::getBloodGroup)
                .reduce(
                        new ArrayList<>(),
                        (bloodGroups, bloodGroup) -> {
                            bloodGroups.add(bloodGroup);
                            return bloodGroups;
                        },
                        (bloodGroups, otherBloodGroups) -> {
                            bloodGroups.addAll(otherBloodGroups);
                            return bloodGroups;
                        }
                );
    }

}

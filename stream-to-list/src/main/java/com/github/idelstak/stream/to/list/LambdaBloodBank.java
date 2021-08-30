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
public class LambdaBloodBank extends AbstractBloodBank {

    @Override
    public List<String> getAvailableTypes() {
        return donors.stream() //(1)
                .map(donor -> donor.getBloodGroup()) //(2)
                .collect(
                        () -> new ArrayList<String>(), //(3)
                        (bloodGroups, bloodGroup) -> bloodGroups.add(bloodGroup), //(4)
                        (resultList, bloodGroups) -> resultList.addAll(bloodGroups) //(5)
                );
    }

}

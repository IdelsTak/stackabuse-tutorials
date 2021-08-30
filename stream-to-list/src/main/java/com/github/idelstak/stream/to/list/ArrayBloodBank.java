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
public class ArrayBloodBank extends AbstractBloodBank {

    @Override
    public List<String> getAvailableTypes() {
        String[] bloodGroupArr = donors.stream()
                .map(Donor::getBloodGroup)
                .toArray(String[]::new);

        return Arrays.asList(bloodGroupArr);
    }

}

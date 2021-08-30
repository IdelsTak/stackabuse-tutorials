/*
 * Copyright 2021
 */
package com.github.idelstak.stream.to.list;

import java.util.List;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class CustomCollectorBloodBank extends AbstractBloodBank {

    @Override
    public List<String> getAvailableTypes() {
        return donors.stream()
                .map(Donor::getBloodGroup)
                .collect(new CustomCollector());
    }

}

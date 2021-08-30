/*
 * Copyright 2021
 */
package com.github.idelstak.stream.to.list;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class CollectorsBloodBank extends AbstractBloodBank {

    @Override
    public List<String> getAvailableTypes() {
        return donors.stream().map(Donor::getBloodGroup).collect(Collectors.toList());
    }

}

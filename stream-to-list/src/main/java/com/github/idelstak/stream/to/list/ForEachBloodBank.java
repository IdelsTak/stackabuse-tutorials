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
public class ForEachBloodBank extends AbstractBloodBank {

    @Override
    public List<String> getAvailableTypes() {
        List<String> bloodGroups  = new ArrayList<>();
        
        donors.stream()
                .map(Donor::getBloodGroup)
                .forEach(bloodGroups::add);
        
        return bloodGroups;
    }

}

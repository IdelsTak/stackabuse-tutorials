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
public class MembersBloodBank extends AbstractBloodBank {

    @Override
    public List<String> getAvailableTypes() {
        return donors.stream()
                .map(Donor::getBloodGroup)
                .collect(
                        ArrayList::new,
                        ArrayList::add,
                        ArrayList::addAll
                );
    }

}

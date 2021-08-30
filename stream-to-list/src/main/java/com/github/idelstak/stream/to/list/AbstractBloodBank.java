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
public abstract class AbstractBloodBank implements BloodBank {

    protected final List<Donor> donors;

    public AbstractBloodBank() {
        this.donors = new ArrayList<>();
    }

    @Override
    public void receiveDonationFrom(Donor donor) {
        donors.add(donor);
    }

    @Override
    public abstract List<String> getAvailableTypes();

}

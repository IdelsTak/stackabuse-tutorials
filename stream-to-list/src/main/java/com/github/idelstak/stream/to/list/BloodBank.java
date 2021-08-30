/*
 * Copyright 2021
 */
package com.github.idelstak.stream.to.list;

import java.util.List;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public interface BloodBank {

    void receiveDonationFrom(Donor donor);

    List<String> getAvailableTypes();
    
}

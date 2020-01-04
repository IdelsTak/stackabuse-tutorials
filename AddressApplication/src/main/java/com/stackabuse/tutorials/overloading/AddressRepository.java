/*
 * Copyright 2020.
 */
package com.stackabuse.tutorials.overloading;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 *
 * @author Hiram K. <hiram.kamau@outlook.com>
 */
public class AddressRepository {

    private final ObservableList<Address> addresses
            = FXCollections.observableArrayList();

    public void addListener(ListChangeListener<? super Address> listener) {
        addresses.addListener(listener);
    }

    public void addListener(InvalidationListener listener) {
        addresses.addListener(listener);
    }

    public ObservableList<Address> getAddresses() {
        return FXCollections.unmodifiableObservableList(addresses);
    }
    
}

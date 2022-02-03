package com.stackabuse.tutorials.overloading;

import javafx.beans.Observable;
import javafx.collections.ListChangeListener.Change;

/** JavaFX AddressApplication */
public class AddressApplication {

  public static void main(String[] args) {
    var repository = new AddressRepository();

    repository.addListener(
        (Change<? extends Address> change) -> {
          //
        });

    repository.addListener(
        (Observable observable) -> {
          //
        });

    var address = new Address();

    address.setDetails("18T", "3", "4C", "North Crowell", "Chicago", "IL");

    address.setDetails();
  }
}

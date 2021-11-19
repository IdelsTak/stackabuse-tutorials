/*
 * Copyright (C) 2021
 */
package com.github.idelstak.joining.practice.names;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class Invitee {

  private final String firstName;
  private final String lastName;
  private final boolean RSVPd;

  public Invitee(String firstName, String lastName, boolean RSVPd) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.RSVPd = RSVPd;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public boolean hasRSVPd() {
    return RSVPd;
  }

}

/*
 * Copyright 2021
 */
package com.github.idelstak.stream.to.list;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class LambdaBloodBankTest {

    @Test
    public void shouldListAvailableBloodTypes() {
        BloodBank bloodBank = new StreamReduceBloodBank();

        bloodBank.receiveDonationFrom(new Donor("Douglas Nolan", "O-", 420));
        bloodBank.receiveDonationFrom(new Donor("Doug O'Connell", "O-", 465));
        bloodBank.receiveDonationFrom(new Donor("Aurora Nitzsche", "AB-", 453));
        bloodBank.receiveDonationFrom(new Donor("Awilda Murray", "B-", 448));
        bloodBank.receiveDonationFrom(new Donor("Augustine Okuneva", "A-", 471));
        bloodBank.receiveDonationFrom(new Donor("Donnie Olson", "O+", 464));

        String[] typesArr = new String[]{"O-", "O-", "AB-", "B-", "A-", "O+"};
        List<String> expectedTypes = Arrays.asList(typesArr);

        List<String> actualTypes = bloodBank.getAvailableTypes();

        assertEquals(expectedTypes.size(), actualTypes.size());
        assertEquals(expectedTypes, actualTypes);
    }

}

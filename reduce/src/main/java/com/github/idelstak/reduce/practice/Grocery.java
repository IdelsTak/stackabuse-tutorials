/*
 * Copyright 2021
 */
package com.github.idelstak.reduce.practice;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class Grocery {

    public static void main(String[] args) {
        //Inventory
        Product orange = new Product("Orange", new Price(2.99), new Weight(2.0));
        Product apple = new Product("Apple", new Price(1.99), new Weight(3.0));
        Product tomato = new Product("Tomato", new Price(3.49), new Weight(4.0));
        Product cucumber = new Product("Cucumber", new Price(2.29), new Weight(1.0));
        Product cheese = new Product("Cheese", new Price(9.99), new Weight(1.0));
        Product beef = new Product("Beef", new Price(7.99), new Weight(10.0));
        //Transactions
        List<Transaction> transactions = Arrays.asList(
                new Transaction(orange, 14),
                new Transaction(apple, 12),
                new Transaction(tomato, 5),
                new Transaction(cucumber, 15),
                new Transaction(cheese, 8),
                new Transaction(beef, 6)
        );
        //TESTS
        //Total value of the transaction
        Price totalPrice = transactions.stream()
                .map(Transaction::getTotalPrice)
                .reduce(Price.NIL, Price::add);

        System.out.printf("Total price: $%.2f\n", totalPrice.getValue());
        //Total weight of items in the transaction
        Weight totalWeight = transactions.stream()
                .map(Transaction::getTotalWeight)
                .reduce(Weight.NIL, Weight::add);
        
        System.out.printf("Total weight: %.2f lbs\n", totalWeight.getValue());
        //Highest value in the transaction
        transactions.stream()
                .map(Transaction::getTotalPrice)
                .reduce(Price::getMax)
                .ifPresent(price -> System.out.printf("Highest price: $%.2f\n", price.getValue()));
        //Transaction with the lowest value        
        transactions.stream()
                .reduce(Transaction::getMin)
                .ifPresent(transaction -> System.out.printf("Transaction with lowest value: %s\n", transaction));
    }

}

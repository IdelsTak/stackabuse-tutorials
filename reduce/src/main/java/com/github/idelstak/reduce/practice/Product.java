/*
 * Copyright 2021
 */
package com.github.idelstak.reduce.practice;

/**
 *
 * @author Hiram K. <https://github.com/IdelsTak>
 */
public class Product {

    private final String name;
    private final Price price;
    private final Weight weight;

    public Product(String name, Price price, Weight weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public Weight getWeight() {
        return weight;
    }

}

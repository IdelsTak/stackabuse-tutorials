/*
 * Copyright 2021
 */
package com.github.idelstak.reduce.practice;

/** @author Hiram K. <https://github.com/IdelsTak> */
public class Transaction {

  private final Product product;
  private final int quantity;

  public Transaction(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public Product getProduct() {
    return product;
  }

  public int getQuantity() {
    return quantity;
  }

  public Price getTotalPrice() {
    return product.getPrice().getTotal(quantity);
  }

  public Weight getTotalWeight() {
    return product.getWeight().getTotal(quantity);
  }

  public Transaction getMin(Transaction otherTransaction) {
    Price min = this.getTotalPrice().getMin(otherTransaction.getTotalPrice());

    return min.equals(this.getTotalPrice()) ? this : otherTransaction;
  }

  @Override
  public String toString() {
    return String.format(
        "{\n" + " Product: %s; price: $%.2f\n" + " Qty: %d lbs\n" + " Total price: $%.2f\n" + "}",
        this.getProduct().getName(),
        this.getProduct().getPrice().getValue(),
        this.getQuantity(),
        this.getTotalPrice().getValue());
  }
}

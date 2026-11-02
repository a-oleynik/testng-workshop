package com.oleynik.qa.workshop.testng.model;

/** Minimal cart for fixture examples; prices and totals use integer minor currency units. */
public class ShoppingCart {
    private int total;

    public void addItem(int unitPrice, int quantity) {
        total += unitPrice * quantity;
    }

    public int getTotal() {
        return total;
    }
}

package com.example.ruburger.model;

/**
 * Enumeration for add-on options with their corresponding prices.
 *
 * @author Muhammad Abbasi moa55 Aaman Gafur atg80
 */
public enum AddOn {
    LETTUCE(0.30),
    TOMATOES(0.40),
    ONIONS(0.30),
    AVOCADO(0.50),
    CHEESE(1.00);

    private final double price;

    AddOn(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

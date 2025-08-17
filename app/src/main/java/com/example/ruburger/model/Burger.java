package com.example.ruburger.model;

import java.util.ArrayList;

/**
 * Burger class represents a burger order.
 */
public class Burger extends MenuItem {

    private Bread bread;
    private ArrayList<AddOn> addOns;
    private int quantity;
    private boolean isDouble;

    public Burger(Bread bread, ArrayList<AddOn> addOns, int quantity, boolean isDouble) {
        this.bread = bread;
        this.addOns = addOns;
        this.quantity = quantity;
        this.isDouble = isDouble;
    }

    @Override
    public double price() {
        double basePrice = 6.99;
        if (isDouble) {
            basePrice += 2.50;
        }
        double addOnPrice = 0.0;
        for (AddOn addon : addOns) {
            addOnPrice += addon.getPrice();
        }
        return (basePrice + addOnPrice) * quantity;
    }

    @Override
    public String toString() {
        return (isDouble ? "Double " : "Single ") + "Burger on " + bread + ", Add-ons: " + addOns;
    }
}

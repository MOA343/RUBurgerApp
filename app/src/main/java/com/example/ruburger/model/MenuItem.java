package com.example.ruburger.model;

/**
 * Represents a generic menu item.
 * Contains the quantity and an abstract method to calculate the price.
 *
 * @author Muhammad Abbasi moa55 Aaman Gafur atg80
 */
public abstract class MenuItem {
    protected int quantity;

    /**
     * Default constructor sets quantity to 1.
     */
    public MenuItem() {
        this.quantity = 1;
    }

    /**
     * Constructs a menu item with the given quantity.
     *
     * @param quantity the quantity of the item
     */
    public MenuItem(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Calculates and returns the price of the menu item.
     *
     * @return the calculated price
     */
    public abstract double price();

    /**
     * Gets the quantity of the item.
     *
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity for the item.
     *
     * @param quantity new quantity value
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

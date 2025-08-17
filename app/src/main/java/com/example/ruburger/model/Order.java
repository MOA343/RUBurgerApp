package com.example.ruburger.model;

import java.util.ArrayList;

/**
 * Represents a customer order with a unique order number and a list of menu items.
 * Calculates totals and holds order data.
 *
 * @author YourName
 */
public class Order {
    private int number;
    private ArrayList<MenuItem> items;
    private static final double TAX_RATE = 0.06625;

    /**
     * Constructs an Order with the specified order number and list of items.
     *
     * @param number the unique order number
     * @param items  the list of menu items in the order
     */
    public Order(int number, ArrayList<MenuItem> items) {
        this.number = number;
        this.items = items;
    }

    // You can also have the original constructor if needed
    /**
     * Constructs an Order with the specified order number and initializes with an empty list.
     *
     * @param number the unique order number
     */
    public Order(int number) {
        this.number = number;
        this.items = new ArrayList<>();
    }

    /**
     * Returns the order number.
     *
     * @return the order number.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Returns the list of menu items in the order.
     *
     * @return the items list.
     */
    public ArrayList<MenuItem> getItems() {
        return items;
    }

    /**
     * Sets the order items.
     *
     * @param items the new list of menu items.
     */
    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
    }

    /**
     * Calculates the subtotal of the order.
     *
     * @return the subtotal.
     */
    public double calculateSubtotal() {
        double subtotal = 0.0;
        for (MenuItem item : items) {
            subtotal += item.price();
        }
        return subtotal;
    }

    /**
     * Calculates the total including sales tax.
     *
     * @return the total amount.
     */
    public double calculateTotal() {
        double subtotal = calculateSubtotal();
        double tax = subtotal * TAX_RATE;
        return subtotal + tax;
    }
}

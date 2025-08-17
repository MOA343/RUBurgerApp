package com.example.ruburger.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton for sharing the current order between Activities.
 */
public class OrderManager {
    private static final OrderManager INSTANCE = new OrderManager();
    private final List<MenuItem> currentOrder = new ArrayList<>();

    /** Private constructor prevents external instantiation */
    private OrderManager() { }

    /** Returns the single shared instance */
    public static OrderManager getInstance() {
        return INSTANCE;
    }

    /** Adds an item to the current order */
    public void addItem(MenuItem item) {
        currentOrder.add(item);
    }

    /** Returns the list of items in the current order */
    public List<MenuItem> getOrder() {
        return currentOrder;
    }

    /** Clears the current order */
    public void clear() {
        currentOrder.clear();
    }
}

package com.example.ruburger.model;

import java.util.ArrayList;

/**
 * Represents a sandwich with a selected bread, protein, and add-on options.
 * Calculates its price based on the protein base price and extra charges for add-ons.
 *
 * Prices are:
 * - Roast Beef: $10.99
 * - Chicken: $8.99
 * - Salmon: $9.99
 *
 * Add-on charges:
 * - Lettuce, Tomatoes, Onions: $0.30 each
 * - Avocado: $0.50
 * - Cheese: $1.00
 *
 * @author Muhammad Abbasi moa55 Aaman Gafur atg80
 */
public class Sandwich extends MenuItem {
    protected Bread bread;
    protected Protein protein;
    protected ArrayList<AddOn> addOns;

    /**
     * Default constructor.
     */
    public Sandwich() {
        super();
        this.addOns = new ArrayList<>();
    }

    /**
     * Constructs a Sandwich with specified bread, protein, add-ons, and quantity.
     *
     * @param bread    the type of bread.
     * @param protein  the protein selected.
     * @param addOns   the list of add-ons.
     * @param quantity the quantity of sandwiches.
     */
    public Sandwich(Bread bread, Protein protein, ArrayList<AddOn> addOns, int quantity) {
        super(quantity);
        this.bread = bread;
        this.protein = protein;
        this.addOns = addOns;
    }

    /**
     * Calculates and returns the total price for the sandwich(es).
     *
     * @return the total price.
     */
    @Override
    public double price() {
        double basePrice = 0.0;
        if (protein != null) {
            switch (protein) {
                case ROAST_BEEF:
                    basePrice = 10.99;
                    break;
                case CHICKEN:
                    basePrice = 8.99;
                    break;
                case SALMON:
                    basePrice = 9.99;
                    break;
                default:
                    basePrice = 0.0;
            }
        }
        double addOnPrice = 0.0;
        if (addOns != null) {
            for (AddOn addon : addOns) {
                switch (addon) {
                    case LETTUCE:
                    case TOMATOES:
                    case ONIONS:
                        addOnPrice += 0.30;
                        break;
                    case AVOCADO:
                        addOnPrice += 0.50;
                        break;
                    case CHEESE:
                        addOnPrice += 1.00;
                        break;
                    default:
                        break;
                }
            }
        }
        return (basePrice + addOnPrice) * quantity;
    }

    /**
     * Returns a string representation of the sandwich.
     *
     * @return a string describing the sandwich.
     */
    @Override
    public String toString() {
        return String.format("Sandwich: Bread: %s, Protein: %s, AddOns: %s, Quantity: %d, Price: $%.2f",
                bread,
                protein,
                (addOns != null && !addOns.isEmpty() ? addOns.toString() : "None"),
                quantity,
                price());
    }
}

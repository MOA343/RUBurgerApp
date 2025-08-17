package com.example.ruburger.model;

/**
 * Represents a combo meal consisting of a sandwich, a beverage, and a side.
 * A fixed combo charge of $2.00 is added.
 *
 * @author Muhammad Abbasi moa55 Aaman Gafur atg80
 */
public class Combo extends MenuItem {
    private Sandwich sandwich;
    private Beverage drink;
    private Side side;

    /**
     * Constructs a Combo with the given sandwich, beverage, side, and quantity.
     *
     * @param sandwich the sandwich component.
     * @param drink    the beverage component.
     * @param side     the side component.
     * @param quantity the number of combos.
     */
    public Combo(Sandwich sandwich, Beverage drink, Side side, int quantity) {
        super(quantity);
        this.sandwich = sandwich;
        this.drink = drink;
        this.side = side;
    }

    /**
     * Calculates and returns the combo price by summing the prices of the components plus a fixed charge.
     *
     * @return the combo price.
     */
    @Override
    public double price() {
        final double COMBO_CHARGE = 2.00;
        double total = sandwich.price() + drink.price() + side.price() + COMBO_CHARGE;
        return total * quantity;
    }

    /**
     * Returns a string representation of the combo.
     *
     * @return a string describing the combo.
     */
    @Override
    public String toString() {
        return String.format("Combo: [%s, %s, %s], Quantity: %d, Price: $%.2f",
                sandwich, drink, side, quantity, price());
    }
}

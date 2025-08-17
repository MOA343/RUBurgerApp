package com.example.ruburger.model;

/**
 * Represents a beverage with a specified size and flavor.
 * Price depends on size:
 * - Small: $1.99
 * - Medium: $2.49
 * - Large: $2.99
 *
 * @author Muhammad Abbasi moa55 Aaman Gafur atg80
 */
public class Beverage extends MenuItem {
    private Size size;
    private Flavor flavor;

    /**
     * Default constructor.
     */
    public Beverage() {
        super();
    }

    /**
     * Constructs a Beverage with the given size, flavor, and quantity.
     *
     * @param size     the selected size.
     * @param flavor   the selected flavor.
     * @param quantity the number of beverages.
     */
    public Beverage(Size size, Flavor flavor, int quantity) {
        super(quantity);
        this.size = size;
        this.flavor = flavor;
    }

    /**
     * Calculates and returns the total price for the beverage(s).
     *
     * @return the price.
     */
    @Override
    public double price() {
        double basePrice = 0.0;
        if (size != null) {
            switch (size) {
                case SMALL:
                    basePrice = 1.99;
                    break;
                case MEDIUM:
                    basePrice = 2.49;
                    break;
                case LARGE:
                    basePrice = 2.99;
                    break;
                default:
                    basePrice = 1.99;
            }
        }
        return basePrice * quantity;
    }

    /**
     * Returns a string representation of the beverage.
     *
     * @return a string describing the beverage.
     */
    @Override
    public String toString() {
        return String.format("Beverage: Size: %s, Flavor: %s, Quantity: %d, Price: $%.2f",
                size,
                flavor,
                quantity,
                price());
    }

    // Getters and setters as needed.
}

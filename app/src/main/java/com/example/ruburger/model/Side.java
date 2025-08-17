package com.example.ruburger.model;

/**
 * Represents a side item with an option and a size.
 * Base prices:
 * - Chips: $1.99
 * - Fries: $2.49
 * - Onion Rings: $3.29
 * - Apple Slices: $1.29
 *
 * For sizes:
 * - Medium: add $0.50
 * - Large: add $1.00
 *
 * @author Muhammad Abbasi moa55 Aaman Gafur atg80
 */
public class Side extends MenuItem {
    private SideOption option;
    private Size size;

    /**
     * Constructs a Side with the specified option, size, and quantity.
     *
     * @param option   the side option.
     * @param size     the size.
     * @param quantity the number of sides.
     */
    public Side(SideOption option, Size size, int quantity) {
        super(quantity);
        this.option = option;
        this.size = size;
    }

    /**
     * Calculates and returns the total price for the side(s).
     *
     * @return the price.
     */
    @Override
    public double price() {
        double basePrice = 0.0;
        if (option != null) {
            switch (option) {
                case CHIPS:
                    basePrice = 1.99;
                    break;
                case FRIES:
                    basePrice = 2.49;
                    break;
                case ONION_RINGS:
                    basePrice = 3.29;
                    break;
                case APPLE_SLICES:
                    basePrice = 1.29;
                    break;
                default:
                    basePrice = 0.0;
            }
        }
        if (size != null) {
            switch (size) {
                case MEDIUM:
                    basePrice += 0.50;
                    break;
                case LARGE:
                    basePrice += 1.00;
                    break;
                default:
                    break;
            }
        }
        return basePrice * quantity;
    }

    /**
     * Returns a string representation of the side.
     *
     * @return a string describing the side.
     */
    @Override
    public String toString() {
        return String.format("Side: Option: %s, Size: %s, Quantity: %d, Price: $%.2f",
                option,
                size,
                quantity,
                price());
    }

    // Getters and setters as needed.
}

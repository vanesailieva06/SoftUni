package solid.products.drinks;

import solid.products.Product;

public abstract class Drinks implements Product {
    private final double milliliters;
    private final double calories;
    private final double density;

    public Drinks(double milliliters, double calories, double density) {
        this.milliliters = milliliters;
        this.calories = calories;
        this.density = density;
    }

    @Override
    public double getCalories() {
        return calories;
    }

    @Override
    public double getGrams() {
        return milliliters * density;
    }
}

package solid.products.drinks;

import solid.products.Product;

public abstract class Drinks implements Product {
    private double milliliters;
    private double calories;
    private double density;

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

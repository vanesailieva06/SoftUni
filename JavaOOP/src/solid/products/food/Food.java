package solid.products.food;

import solid.products.Product;

public abstract class Food implements Product {
    private final double grams;
    private final double calories;

    public Food(double grams, double calories) {
        this.grams = grams;
        this.calories = calories;
    }

    public double getGrams() {
        return grams;
    }

    @Override
    public double getCalories() {
        return calories;
    }
}

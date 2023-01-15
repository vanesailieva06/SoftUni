package solid.calculator;

import solid.products.Product;

import java.util.List;

public class QuantityCalculator implements Calculator {
    public double sum(List<Product> products) {
        double sum = 0;

        for (Product product : products) {
            sum += product.getGrams();
        }

        return sum;
    }

    public double average(List<Product> products) {
        return sum(products) / products.size();
    }
}

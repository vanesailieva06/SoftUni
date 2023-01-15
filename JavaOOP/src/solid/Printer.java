package solid;

import solid.calculator.Calculator;
import solid.products.Product;

import java.util.List;

public abstract class Printer implements Calculator {

    public void printSum(List<Product> products) {
        System.out.println(sum(products));
    }

    public void printAverage(List<Product> products) {
        System.out.println(average(products));
    }
}

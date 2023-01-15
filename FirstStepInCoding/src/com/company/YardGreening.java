package com.company;

import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double squareMetres = Double.parseDouble(scanner.nextLine());
        double allPrice = 7.61 * squareMetres;
        double discount = 0.18 * allPrice;
        double finalPrice = allPrice - discount;
        System.out.printf("The final price is: %f The discount is: %f", finalPrice ,discount );
    }
}

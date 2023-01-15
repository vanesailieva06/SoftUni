package com.company;

import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countDogFood = Integer.parseInt(scanner.nextLine());
        int countCatFood = Integer.parseInt(scanner.nextLine());
        double priceDogFood = countDogFood * 2.5;
        int priceCatFood = countCatFood * 4;
        double allPrice = priceDogFood + priceCatFood;
                System.out.print(allPrice);
    }
}

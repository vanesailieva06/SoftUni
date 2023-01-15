package com.company;

import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	Брой пакети химикали - цяло число в интервала [0...100]
        //•	Брой пакети маркери - цяло число в интервала [0...100]
        //•	Литри препарат за почистване на дъска - цяло число в интервала [0…50]
        //•	Процент намаление - цяло число в интервала [0...100]
        int pens = Integer.parseInt(scanner.nextLine());
        int markers = Integer.parseInt(scanner.nextLine());
        int litersPreparation = Integer.parseInt(scanner.nextLine());
        int percent = Integer.parseInt(scanner.nextLine());
        double pensPrice = pens * 5.80;
        double markersPrice = markers * 7.20;
        double preparationForLiters = litersPreparation * 1.20;
        double allPriceWithoutDiscount = pensPrice + markersPrice + preparationForLiters;
        double discount = allPriceWithoutDiscount * percent/100;
        double totalPrice = allPriceWithoutDiscount - discount;
        System.out.printf("%f" , totalPrice);

    }
}

package com.company;

import java.util.Scanner;

public class FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	Брой пилешки менюта – цяло число в интервала [0 … 99]
        //•	Брой менюта с риба – цяло число в интервала [0 … 99]
        //•	Брой вегетариански менюта – цяло число в интервала [0 … 99]
        int chickenMenus = Integer.parseInt(scanner.nextLine());
        int fishMenus = Integer.parseInt(scanner.nextLine());
        int vegetarianMenus = Integer.parseInt(scanner.nextLine());
        //•	Пилешко меню –  10.35 лв.
        //•	Меню с риба – 12.40 лв.
        //•	Вегетарианско меню  – 8.15 лв.
        double chickenPrice = chickenMenus * 10.35;
        double fishPrice = fishMenus * 12.40;
        double vegetarianPrice = vegetarianMenus * 8.15;
        double pricesWithoutDesert = chickenPrice + fishPrice +vegetarianPrice;
        double desertPrice = pricesWithoutDesert * 0.20;
        double delivery = 2.50;
        double totalPrice = pricesWithoutDesert + desertPrice + delivery;
        System.out.printf("%f" , totalPrice);
    }
}

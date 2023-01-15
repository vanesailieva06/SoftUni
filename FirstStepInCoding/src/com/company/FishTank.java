package com.company;

import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1.	Дължина в см – цяло число в интервала [10 … 500]
        //2.	Широчина в см – цяло число в интервала [10 … 300]
        //3.	Височина в см – цяло число в интервала [10… 200]
        //4.	Процент  – реално число в интервала [0.000 … 100.000]
        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percentAccessories = Double.parseDouble(scanner.nextLine());
        double sizeInCm = length * width * height;
        double sizeInDm = sizeInCm / 1000;
        double neededLiters = sizeInDm - (sizeInDm * percentAccessories / 100);
        System.out.println(neededLiters);
    }
}

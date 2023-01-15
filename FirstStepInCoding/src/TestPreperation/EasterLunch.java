package TestPreperation;

import java.util.Scanner;

public class EasterLunch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int easterBread = Integer.parseInt(scanner.nextLine());
        int boxOfEggs = Integer.parseInt(scanner.nextLine());
        int kgCookies = Integer.parseInt(scanner.nextLine());

        //•	Козунак  – 3.20 лв.
        //•	Яйца –  4.35 лв. за кора с 12 яйца
        //•	Курабии – 5.40 лв. за килограм
        //•	Боя за яйца - 0.15 лв. за яйце
        double easterBreadPrice = 3.20 * easterBread;
        double eggsPrice = 4.35 * boxOfEggs;
        double cookiesPrice = 5.40 * kgCookies;
        double paintForEggs = 0.15 * boxOfEggs * 12;
        double total = easterBreadPrice + eggsPrice + cookiesPrice + paintForEggs;
        System.out.printf("%.2f", total);
    }
}

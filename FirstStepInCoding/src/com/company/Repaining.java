package com.company;

import java.util.Scanner;

public class Repaining {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       // 1.	Необходимо количество найлон (в кв.м.) - цяло число в интервала [1... 100]
       // 2.	Необходимо количество боя (в литри) - цяло число в интервала [1…100]
       // 3.	Количество разредител (в литри) - цяло число в интервала [1…30]
       // 4.	Часовете, за които майсторите ще свършат работата - цяло число в интервала [1…9]
        int nylon = Integer.parseInt(scanner.nextLine());
        int paint = Integer.parseInt(scanner.nextLine());
        int thinner = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());
        //•	Предпазен найлон - 1.50 лв. за кв. метър
        //•	Боя - 14.50 лв. за литър
        //•	Разредител за боя - 5.00 лв. за литър
        double nylonPrice = nylon * 1.50;
        double paintPrice = paint * 14.50;
        double thinnerPrice = thinner * 5.00;
        double addedPaint = paint * 0.10;
        double addedNylon = 2 * 1.50;
        double bags = 0.40;
        double allNylonPrice = nylonPrice + addedNylon;
        double allPaintPrice = (paint + addedPaint) * 14.50;
        double priceForMaterials = allNylonPrice + allPaintPrice + thinnerPrice + bags;
        double priceForOneHour = (priceForMaterials * 0.30) * hours;
        double totalPrice = priceForMaterials + priceForOneHour;
        System.out.println(totalPrice);



    }
}

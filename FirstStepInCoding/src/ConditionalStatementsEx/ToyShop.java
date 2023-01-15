package ConditionalStatementsEx;

import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double vacation = Double.parseDouble(scanner.nextLine());
        int puzzle = Integer.parseInt(scanner.nextLine());
        int doll = Integer.parseInt(scanner.nextLine());
        int teddyBear = Integer.parseInt(scanner.nextLine());
        int minion = Integer.parseInt(scanner.nextLine());
        int truck = Integer.parseInt(scanner.nextLine());
        double puzzlePrice = 2.60 * puzzle;
        double dollPrice = 3.00 * doll;
        double teddyBearPrice = 4.10 * teddyBear;
        double minionPrice = 8.20 * minion;
        double truckPrice = 2.00 * truck;
        int allToys = puzzle + doll + teddyBear + minion + truck;
        double discount = 0;
        double allPrice = puzzlePrice + dollPrice + teddyBearPrice + minionPrice + truckPrice;


        if(allToys >= 50){
            discount =  allPrice * 0.25;
        }
        double finalPrice = allPrice - discount;
        double rent = finalPrice * 0.10;
        double profit = finalPrice  - rent;
        double remainingMoney = profit - vacation;
        if(profit >= vacation){
            System.out.printf("Yes! %.2f lv left." , Math.abs(remainingMoney));
        }else{
            System.out.printf("Not enough money! %.2f lv needed." , Math.abs(remainingMoney));
        }

    }
}

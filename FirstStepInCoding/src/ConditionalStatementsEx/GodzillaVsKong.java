package ConditionalStatementsEx;

import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int worker = Integer.parseInt(scanner.nextLine());
        double clothesPriceForOneWorker = Double.parseDouble(scanner.nextLine());
        double decor = budget * 0.10;
        clothesPriceForOneWorker = clothesPriceForOneWorker * worker;
        double decorDiscount = 0;

        if(worker > 150){
            decorDiscount = clothesPriceForOneWorker * 0.10;
        }
        double totalPrice = clothesPriceForOneWorker + decor - decorDiscount;
        double neededMoney = totalPrice - budget;

        if(totalPrice > budget){
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more." , Math.abs(neededMoney));
        }else{
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", Math.abs(neededMoney));
        }
    }
}

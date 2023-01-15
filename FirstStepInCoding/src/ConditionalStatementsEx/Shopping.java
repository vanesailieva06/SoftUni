package ConditionalStatementsEx;

import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int videoCards = Integer.parseInt(scanner.nextLine());
        int processor = Integer.parseInt(scanner.nextLine());
        int ram = Integer.parseInt(scanner.nextLine());
        int videoCardsPrice = 250 * videoCards;
        double processorPrice = 0.35 * videoCardsPrice;
        double processorTotalPrice = processor * processorPrice;
        double ramPrice = 0.10 * videoCardsPrice;
        double ramTotalPrice = ram * ramPrice;
        double totalPrice = videoCardsPrice + processorTotalPrice + ramTotalPrice;
        double discount = 0;
        if(videoCards > processor ){
            discount = 0.15 * totalPrice;
        }
        double totalPriceWithDiscount = totalPrice - discount;
        double neededMoney = totalPriceWithDiscount - budget;
        if(budget > totalPrice){
            System.out.printf("You have %.2f leva left!" , Math.abs(neededMoney));
        }else{
            System.out.printf("Not enough money! You need %.2f leva more!" , Math.abs(neededMoney));
        }
    }
}

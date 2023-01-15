package TestPreperation;

import java.util.Scanner;

public class MobileOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String termContract = scanner.nextLine();
        String typeContract = scanner.nextLine();
        String internet = scanner.nextLine();
        double contractPrice = 0;
        double internetPrice = 0;
        int months = Integer.parseInt(scanner.nextLine());
        if (termContract.equals("one")) {
            if (typeContract.equals("Small")) {
                contractPrice = 9.98;
            } else if (typeContract.equals("Middle")) {
                contractPrice = 18.99;
            } else if (typeContract.equals("Large")) {
                contractPrice = 25.98;
            } else if (typeContract.equals("ExtraLarge")) {
                contractPrice = 35.99;
            }

        }else if (termContract.equals("two")){
            if (typeContract.equals("Small")) {
                contractPrice = 8.48;
            } else if (typeContract.equals("Middle")) {
                contractPrice = 17.09;
            } else if (typeContract.equals("Large")) {
                contractPrice = 23.59;
            } else if (typeContract.equals("ExtraLarge")) {
                contractPrice = 31.79;
            }
        }
        if (internet.equals("yes")){
            if (contractPrice <= 10){
                internetPrice = 5.50;
            }else if (contractPrice <= 30){
                internetPrice = 4.35;
            }else if (contractPrice > 30){
                internetPrice = 3.85;
            }
        }


        double priceWithInternet = contractPrice + internetPrice;
        if (termContract.equals("two")){
            priceWithInternet = priceWithInternet - (priceWithInternet * 3.75/100);
        }
        double totalPrice = priceWithInternet * months;
        System.out.printf("%.2f lv.", totalPrice);
    }
}

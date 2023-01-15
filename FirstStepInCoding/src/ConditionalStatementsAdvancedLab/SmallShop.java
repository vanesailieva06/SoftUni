package ConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class SmallShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        String city = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());
        double productPrice = 0;


        if ("coffee".equals(product)) {
            if ("Sofia".equals(city)) {
                productPrice = 0.50;
            } else if ("Plovdiv".equals(city)) {
                productPrice = 0.40;
            } else if ("Varna".equals(city)) {
                productPrice = 0.45;
            }
        } else if ("water".equals(product)) {
            if ("Sofia".equals(city)) {
                productPrice = 0.80;
            } else if ("Plovdiv".equals(city)) {
                productPrice = 0.70;
            } else if ("Varna".equals(city)) {
                productPrice = 0.70;
            }
        } else if ("beer".equals(product)) {
            if ("Sofia".equals(city)) {
                productPrice = 1.20;
            } else if ("Plovdiv".equals(city)) {
                productPrice = 1.15;
            } else if ("Varna".equals(city)) {
                productPrice = 1.10;
            }
        } else if ("sweets".equals(product)) {
            if ("Sofia".equals(city)) {
                productPrice = 1.45;
            } else if ("Plovdiv".equals(city)) {
                productPrice = 1.30;
            } else if ("Varna".equals(city)) {
                productPrice = 1.35;
            }
        } else if("peanuts".equals(product)){
            if ("Sofia".equals(city)) {
                productPrice = 1.60;
            } else if ("Plovdiv".equals(city)) {
                productPrice = 1.50;
            } else if ("Varna".equals(city)) {
                productPrice = 1.55;
            }
        }
        double totalPrice = quantity * productPrice;

        System.out.println(totalPrice);
    }
}

package Test;

import java.util.Scanner;

public class MiningRig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int videoCardPrice = Integer.parseInt(scanner.nextLine());
        int adapterPrice = Integer.parseInt(scanner.nextLine());
        double electricityForOneCard = Double.parseDouble(scanner.nextLine());
        double profit = Double.parseDouble(scanner.nextLine());

        int allCardPrice = 13 * videoCardPrice;
        int allAdapterPrice = 13 * adapterPrice;
        int otherCosts = 1000;
        int moneySpent = allCardPrice + allAdapterPrice + otherCosts;
        double profitForOneCard = profit - electricityForOneCard;
        double profitForAllCard = 13 * profitForOneCard;
        double daysForReturn = Math.ceil(moneySpent / profitForAllCard);
        System.out.println(moneySpent);
        System.out.printf("%.0f", daysForReturn);

    }
}

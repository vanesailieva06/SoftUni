package MidExam;

import java.util.Scanner;

public class BurgerBus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCities = Integer.parseInt(scanner.nextLine());
        double profitForEachCity = 0;
        double totalProfit = 0;
        for (int i = 1; i <= numOfCities ; i++) {
            String nameOfTheCity = scanner.nextLine();
            double income = Double.parseDouble(scanner.nextLine());
            double expenses = Double.parseDouble(scanner.nextLine());
            profitForEachCity = income - expenses;
            if (i % 5 == 0){
                double lossIncome = income * 0.10;
                double incomeWIthLossIncome = profitForEachCity - lossIncome;
                profitForEachCity = incomeWIthLossIncome;

            }
            if (i % 3 == 0 && i % 5 != 0){
                double specialEvent = expenses * 0.50;
                double sumWithSpecialEvent = profitForEachCity - specialEvent;
                profitForEachCity = sumWithSpecialEvent;
            }
            totalProfit += profitForEachCity;
            System.out.printf("In %s Burger Bus earned %.2f leva.%n", nameOfTheCity, profitForEachCity);
        }
        System.out.printf("Burger Bus total profit: %.2f leva.", totalProfit);
    }
}

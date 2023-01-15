package Test;

import java.util.Scanner;

public class GoldMine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int location = Integer.parseInt(scanner.nextLine());
        double averageYield = 0;
        int kgForAllDays = 0;
        double neededGold = 0;

        for (int n = 1; n <= location; n++){
            double expectedAverageYield = Double.parseDouble(scanner.nextLine());
            double neededDays = Integer.parseInt(scanner.nextLine());
            for (int d = 1; d <= neededDays; d++){
                int kgForOneDay = Integer.parseInt(scanner.nextLine());
                 kgForAllDays = kgForOneDay + kgForAllDays;
                 averageYield = kgForAllDays / neededDays;
                 neededGold = Math.abs(averageYield - expectedAverageYield);
            }
            if (averageYield >= expectedAverageYield){
                System.out.printf("Good job! Average gold per day: %.2f.%n", averageYield);
            }else{
                System.out.printf("You need %.2f gold.", neededGold);
            }
            kgForAllDays = 0;
        }
    }
}

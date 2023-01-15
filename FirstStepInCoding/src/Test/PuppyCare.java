package Test;

import java.util.Scanner;

public class PuppyCare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int boughtFoodInKg = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int allNeededFood = 0;
        int leftovers = 0;
        int boughtFoodInGr = 0;

        while (!input.equals("Adopted")){
            int neededFoodForOneMeal = Integer.parseInt(input);
            allNeededFood = allNeededFood + neededFoodForOneMeal;
            boughtFoodInGr = boughtFoodInKg * 1000;
            leftovers = Math.abs(boughtFoodInGr - allNeededFood);
            input = scanner.nextLine();

        }
        if (boughtFoodInGr >= allNeededFood){
            System.out.printf("Food is enough! Leftovers: %d grams." , leftovers);
        }else{
            System.out.printf("Food is not enough. You need %d grams more.", leftovers );
        }
    }
}

package WhaleLab;

import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double sum =0;
        boolean isNegative = false;

        while (!input.equals("NoMoreMoney")){
            double num = Double.parseDouble(input);
            if (num < 0){
                isNegative = true;
                break;
            }
            sum = sum + num;
            System.out.printf("Increase: %.2f%n", num);
            input = scanner.nextLine();



        }
        if(isNegative){
            System.out.println("Invalid operation!");
        }

        System.out.printf("Total: %.2f", sum);

    }
}

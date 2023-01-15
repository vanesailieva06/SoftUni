package MethodEx;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        double sum = factorial1(n1) * 1.00 / factorial2(n2);
        System.out.printf("%.2f", sum);
    }

    public static Integer factorial1(int number1){
        int factorial = 1;
        for (int i = 1; i <= number1 ; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }
    public static Integer factorial2(int number2){
        int factorial = 1;
        for (int i = 1; i <= number2 ; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }
}

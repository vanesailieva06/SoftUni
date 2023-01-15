package Negotiation;

import java.util.Scanner;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int num= 1;
        for (int i = 0; i< n; i++){
                System.out.println(num);
                sum = sum + num;
            num = 2 + num;
        }
        System.out.printf("Sum: %d", sum);
    }
}

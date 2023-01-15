package Negotiation;

import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int times = Integer.parseInt(scanner.nextLine());
        int result = 0;
        int resultWithBiggerNum = num * times;
        if (times > 10){
            System.out.printf("%d X %d = %d", num, times, resultWithBiggerNum);
        }
        while (times <= 10){
            result = num * times;
            System.out.printf("%d X %d = %d%n", num, times, result);
            times++;
        }

    }
}

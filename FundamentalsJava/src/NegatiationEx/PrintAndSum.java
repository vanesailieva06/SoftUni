package NegatiationEx;

import java.util.Scanner;

public class PrintAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startNum = Integer.parseInt(scanner.nextLine());
        int endNum = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int num = startNum; num <= endNum; num++){
            System.out.printf("%d ",num);
            sum += num;

        }
        System.out.printf("%nSum: %d", sum);
    }
}

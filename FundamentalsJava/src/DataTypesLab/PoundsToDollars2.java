package DataTypesLab;

import java.util.Scanner;

public class PoundsToDollars2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float pound = Float.parseFloat(scanner.nextLine());
        //1 British Pound = 1.36 Dollars
        float dollars = 1.36f * pound;
        System.out.printf("%.3f", dollars);
    }
}

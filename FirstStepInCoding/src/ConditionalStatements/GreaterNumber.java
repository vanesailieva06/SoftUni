package ConditionalStatements;

import java.util.Scanner;

public class GreaterNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numA = Integer.parseInt(scanner.nextLine());
        int numB = Integer.parseInt(scanner.nextLine());
        if (numA > numB){
          System.out.println(numA);
        } else {
            System.out.println(numB);
        }
    }
}

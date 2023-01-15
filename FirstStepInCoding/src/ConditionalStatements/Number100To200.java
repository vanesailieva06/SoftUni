package ConditionalStatements;

import java.util.Scanner;

public class Number100To200 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
       // •	под 100 отпечатайте: "Less than 100"
        //•	между 100 и 200 отпечатайте: "Between 100 and 200"
        //•	над 200 отпечатайте: "Greater than 200"
        if (num < 100){
            System.out.println("Less than 100");
        } else if(num <= 200){
            System.out.println("Between 100 and 200");
        } else if (num > 200){
            System.out.println("Greater than 200");
        }
    }
}

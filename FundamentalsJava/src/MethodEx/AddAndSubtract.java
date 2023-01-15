package MethodEx;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());
        //num1 + num2 -> method
        //sum(num1 + num2) -> method
        System.out.println(subtractSum(num1,num2,num3));
    }

    public static Integer sum(int number1, int number2){
        int sum = number1 + number2;
        return sum;
    }
    public static Integer subtractSum(int number1,int number2, int number3){
        int sum2 = sum(number1,number2) - number3;
        return sum2;
    }
}

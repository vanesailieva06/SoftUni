package MethodEx;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        //if the length is odd -> 1 middle character method
        //if the length is even -> 2 middle character method
        if (input.length() % 2 == 0){
            printMiddleCharacterEven(input);
        }else{
            printMiddleCharacterOdd(input);
        }
    }

    public static void printMiddleCharacterOdd(String nameOdd){
            int middleChar = nameOdd.length() / 2;
            System.out.println(nameOdd.charAt(middleChar));
    }

    public static void printMiddleCharacterEven(String nameEven){
        int middleChar1 = nameEven.length() / 2;
        int middleChar2 = nameEven.length() / 2 - 1;
        System.out.print(nameEven.charAt(middleChar2));
        System.out.print(nameEven.charAt(middleChar1));
    }
}

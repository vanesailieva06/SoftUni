package MethodEx;

import java.util.Locale;
import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine().toLowerCase();
        printCountOfVowels(name);

    }

    public static void printCountOfVowels(String name){
        int sumOfVowels = 0;
        for (char symbol : name.toCharArray()) {
            if (symbol == 'a' || symbol == 'e' || symbol == 'o' || symbol == 'i' || symbol == 'u'){
                sumOfVowels++;
            }
        }
        System.out.println(sumOfVowels);
    }
}

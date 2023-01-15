package TextProcessingEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String input = scanner.nextLine();

        String newInput = "";

        char firstOccur = input.charAt(0);
        newInput += firstOccur;

        for (int i = 1; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if (currentSymbol != firstOccur) {
                newInput += currentSymbol;
                firstOccur = currentSymbol;
            }

        }

        System.out.println(newInput);


    }
}

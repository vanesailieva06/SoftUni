package TextProcessingEx;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String input = scanner.nextLine();
        for (char symbol : input.toCharArray()){
            int newSymbolInt = (int) symbol + 3;
            char newSymbol = (char)newSymbolInt;
            System.out.print(newSymbol);
        }
    }
}

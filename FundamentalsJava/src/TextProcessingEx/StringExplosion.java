package TextProcessingEx;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder newInput = new StringBuilder(input);
        int strength = 0;
        for (int i = 0; i < input.length() - 1; i++) {
            int currentStrength =+ strength;
            if (input.charAt(i) == '>' ){
                strength = i + 1;
                newInput.deleteCharAt(i + 1);
                if (newInput.charAt(1 + 1) == '>'){
                    continue;
                }
                i--;
            }
        }
        System.out.println();
    }
}

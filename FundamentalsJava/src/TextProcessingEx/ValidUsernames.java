package TextProcessingEx;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArr = input.split(", ");
        for (int i = 0; i < inputArr.length; i++) {
            String currentWord = inputArr[i];
            if (isValidUsername(currentWord)){
                System.out.println(currentWord);
            }
        }


    }
    public static boolean isValidUsername(String word){
        //•	Has a length between 3 and 16 characters.
        //•	Contains only letters, numbers, hyphens, and underscores.
        if (word.length() < 3 || word.length() > 16){
            return false;
        }
        for (char symbol : word.toCharArray()){
            if (!Character.isLetter(symbol) && !Character.isDigit(symbol) && symbol != '-' && symbol != '_'){
                return false;
            }
        }
        return true;
    }
}

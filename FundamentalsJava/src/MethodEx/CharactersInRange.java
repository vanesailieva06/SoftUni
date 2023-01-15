package MethodEx;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pass = scanner.nextLine();
        //•	6 – 10 characters (inclusive); -> метод
        //•	Consists only of letters and digits; -> метод
        //•	Have at least 2 digits. -> метод
        if (!isValidNUmberOfChars(pass)){
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!isValidLettersAndDigits(pass)){
            System.out.println("Password must consist only of letters and digits");
        }
        if (!isValidAtLeast2Digits(pass)){
            System.out.println("Password must have at least 2 digits");
        }
        if (isValidNUmberOfChars(pass) && isValidLettersAndDigits(pass) && isValidAtLeast2Digits(pass)){
            System.out.println("Password is valid");
        }

    }

    public static boolean isValidNUmberOfChars(String password){

            if (password.length() >= 6 && password.length() <= 10){
                return true;
            }
            else{
                return false;
            }
    }
    public static boolean isValidLettersAndDigits(String password){
        for (char symbol : password.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)){
                return false;
            }
        }
        return true;
    }
    public static boolean isValidAtLeast2Digits(String password){
        int countDigits = 0;
        for (char symbol : password.toCharArray()) {
            if (Character.isDigit(symbol)){
                countDigits++;
            }
        }
        return countDigits >= 2;
    }
}

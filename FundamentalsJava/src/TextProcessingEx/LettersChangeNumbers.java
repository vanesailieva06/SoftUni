package TextProcessingEx;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String[] inputArr = scanner.nextLine().split("\\s+");
        double sum = 0;
        double resultFirstLetter = 0;
        double result = 0;
        for (String input : inputArr){
            String firstLetter = input.charAt(0) + "";
            String lastLetter = input.charAt(input.length() - 1) + "";
            String newInput = input.replace(firstLetter, "") .replace(lastLetter, "");
            double num = Double.parseDouble(newInput);
            if (Character.isUpperCase(input.charAt(0))){
                 double position = Math.abs(64 - (int)input.charAt(0));
                 resultFirstLetter = num / position;
            }else if (Character.isLowerCase(input.charAt(0))){
                 double position = Math.abs(96 - (int)input.charAt(0));
                 resultFirstLetter = num * position;
            }

            if (Character.isUpperCase(input.charAt(input.length() - 1))){
                double position = Math.abs(64 - (int)input.charAt(input.length() - 1));
                result = resultFirstLetter - position;

            }else if (Character.isLowerCase(input.charAt(input.length() - 1))){
                double position = Math.abs(96 - (int)input.charAt(input.length() - 1));
                result = resultFirstLetter + position;
            }
            sum += result;
        }
        System.out.printf("%.2f", sum);

    }
}

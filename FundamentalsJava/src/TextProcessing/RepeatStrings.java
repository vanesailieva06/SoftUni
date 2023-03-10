package TextProcessing;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String[] wordsArr = scanner.nextLine().split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : wordsArr){
            int count = word.length();
            for (int i = 0; i < word.length(); i++) {
                result.append(word);
            }
        }
        System.out.println(result.toString());
    }
}

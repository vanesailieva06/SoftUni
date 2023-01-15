package TextProcessing;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();
        String[] textArr = text.split("[,  .!/]");
        //StringBuilder newText = new StringBuilder();
        for (String word : bannedWords){
            for (int i = 0; i < textArr.length; i++) {
                if (textArr[i].contains(word)){
                    text = text.replace(word, replacement(word.length(), ""));
                }
            }
        }
        System.out.print(text);


    }
    public static String replacement(int count, String newReplacement){
        for (int i = 0; i < count; i++) {
            String symbol = "*";
            newReplacement += symbol;
        }
        return newReplacement;
    }
}

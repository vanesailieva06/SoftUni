package FinalExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "([@\\#])(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        List<String> matchedWords = new ArrayList<>();
        while(matcher.find()){
            count ++;
            String firstWord = matcher.group("first");
            String secondWord = matcher.group("second");
            StringBuilder firstWordBuilder = new StringBuilder(firstWord);
            StringBuilder reserveWordBuilder = firstWordBuilder.reverse();
            if (reserveWordBuilder.toString().equals(secondWord)){
                matchedWords.add(firstWord + " <=> " + secondWord);
            }
        }
        if (count ==  0){
            System.out.println("No word pairs found!");
            System.out.println("No mirror words!");
        }else{
            System.out.printf("%d word pairs found!%n",count);
            if (matchedWords.size() > 0){
                System.out.println("The mirror words are:");
                System.out.println(String.join(", ", matchedWords));
            }else{
                System.out.println("No mirror words!");
            }
        }
    }
}

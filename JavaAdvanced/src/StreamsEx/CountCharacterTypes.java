package StreamsEx;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("Resources/input.txt");
        PrintWriter writer = new PrintWriter(new FileWriter("Resources/output.txt"));
        int oneByte = reader.read();
        int vowels = 0;
        int punctuation = 0;
        int otherSymbols = 0;
        while (oneByte >= 0){
            char symbol = (char) oneByte;
            if (isVowels(symbol)){
                vowels++;
            } else if (isPunctuation(symbol)) {
                punctuation++;
            }else if (!Character.isWhitespace(symbol)){
                otherSymbols++;
            }
            oneByte = reader.read();
        }
        writer.printf("Vowels: %d%n", vowels);
        writer.printf("Other symbols: %d%n", otherSymbols);
        writer.printf("Punctuation: %d%n", punctuation);
        reader.close();
        writer.close();
    }

    private static boolean isPunctuation(char symbol) {
        //•	Punctuation marks are (! , . ?).
        return symbol == '!' || symbol == ',' || symbol == '.' || symbol == '?';
    }

    private static boolean isVowels(char symbol) {
        //•	a, e, i, o, u are vowels, only lower case.
        return symbol == 'a' || symbol == 'e' ||symbol == 'i' ||symbol == 'o' ||symbol == 'u';
    }
}

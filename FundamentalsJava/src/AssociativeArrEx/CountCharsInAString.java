package AssociativeArrEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String text = scanner.nextLine();
        Map<Character, Integer> countChar = new LinkedHashMap<>();
        for (char symbol : text.toCharArray()){
            if (symbol == ' '){
                continue;
            }
            if (!countChar.containsKey(symbol)){
                int value = 1;
                countChar.put(symbol,value);
            }else{
                int value1 = countChar.get(symbol);
                countChar.put(symbol, value1 + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : countChar.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}

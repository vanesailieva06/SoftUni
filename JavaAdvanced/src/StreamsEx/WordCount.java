package StreamsEx;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Resources/words.txt"));
        String line = reader.readLine();
        String[] arr = line.split(" ");
        Map<String, Integer> countedWord = new LinkedHashMap<>();
        for (String word : arr){
            countedWord.put(word, 0);
        }
        Scanner scanner = new Scanner(new FileReader("Resources/text.txt"));
        String word = scanner.next();
        while (scanner.hasNext()){
            if (countedWord.containsKey(word)){
                int countNum = countedWord.get(word);
                countNum++;
                countedWord.put(word, countNum);
            }
            word = scanner.next();
        }
        PrintWriter writer = new PrintWriter(new FileWriter("Resources/result.txt"));
        countedWord.entrySet().stream().forEach(entry -> writer.printf("%s - %d%n", entry.getKey(), entry.getValue()));
        reader.close();
        writer.close();
    }
}

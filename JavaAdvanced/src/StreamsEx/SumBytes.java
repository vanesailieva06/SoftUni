package StreamsEx;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Resources/input.txt"));
        String line = reader.readLine();
        long sum = 0;
        while (line != null){
            for (char symbol : line.toCharArray()){
                sum += symbol;
            }
            line = reader.readLine();
        }
        System.out.println(sum);
        reader.close();
    }
}

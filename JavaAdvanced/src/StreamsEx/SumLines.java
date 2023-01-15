package StreamsEx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("Resources/input.txt"));
        String line = bf.readLine();
        while(line != null){
            long sum = 0;
            for (char symbol: line.toCharArray()) {
                sum += symbol;
            }
            System.out.println(sum);
            line = bf.readLine();
        }
        bf.close();
    }
}

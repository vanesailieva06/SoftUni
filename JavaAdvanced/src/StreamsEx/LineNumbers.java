package StreamsEx;

import java.io.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Resources/inputLineNumbers.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("Resources/output.txt"));
        String line = reader.readLine();
        int count = 1;
        while (line != null){
            writer.println(count + ". " + line);
            count++;
            line = reader.readLine();
        }
        reader.close();
        writer.close();
    }
}

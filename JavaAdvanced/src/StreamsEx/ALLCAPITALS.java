package StreamsEx;

import java.io.*;

public class ALLCAPITALS {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Resources/input.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("Resources/output.txt"));
        String line = reader.readLine();
        while(line != null){
            writer.println(line.toUpperCase());
            line = reader.readLine();
        }
        reader.close();
        writer.close();
    }
}

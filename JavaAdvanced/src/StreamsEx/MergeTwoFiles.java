package StreamsEx;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader("Resources/inputOne.txt"));
        Scanner scanner1 = new Scanner(new FileReader("Resources/inputTwo.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("Resources/output.txt"));
        String num = scanner.next();
        String num1 = scanner1.next();
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()){
            sb.append(num).append(System.lineSeparator());
            num = scanner.nextLine();
        }
        while (scanner1.hasNext()){
            sb.append(num1).append(System.lineSeparator());
            num1 = scanner1.nextLine();
        }
        writer.println(sb);
        scanner.close();
        scanner1.close();
        writer.close();
    }
}

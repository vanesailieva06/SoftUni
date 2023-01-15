package TextProcessing;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String text = scanner.nextLine();
        while (!text.equals("end")){
            String reservedText = "";
            for (int i = text.length() -1; i >= 0; i--) {
                reservedText += text.charAt(i);
            }
            System.out.printf("%s = %s%n", text, reservedText);
            text = scanner.nextLine();
        }
    }
}

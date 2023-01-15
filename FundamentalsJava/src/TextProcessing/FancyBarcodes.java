package TextProcessing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n ; i++) {
            String input = scanner.nextLine();
            String regex = "[@][#]+(?<word>[A-Z][A-Za-z0-9]{4,}[A-Z])[@][#]+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            String product = "";
            StringBuilder codeBuilder = new StringBuilder();
            if (matcher.find()){
                product = matcher.group("word");
                for (char symbol : product.toCharArray()){
                    if (Character.isDigit(symbol)){
                        codeBuilder.append(symbol);
                    }
                }
            }else{
                System.out.println("Invalid barcode");
                continue;
            }
            if (codeBuilder.toString().equals("")){
                System.out.println("Product group: 00");
            }else{
                System.out.printf("Product group: %s%n", codeBuilder.toString());
            }
        }
    }
}

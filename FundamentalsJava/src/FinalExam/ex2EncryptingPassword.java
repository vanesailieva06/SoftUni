package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ex2EncryptingPassword {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String regex = "([\\W\\w]+)>(?<numbers>[0-9]{3})\\|(?<lowerCase>[a-z]{3})\\|(?<upperCase>[A-Z]{3})\\|(?<symbols>[^<>]{3})<\\1";
        for (int i = 1; i <= n ; i++) {
            String encryptedPass = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(encryptedPass);
            StringBuilder validPass = new StringBuilder();
            if (matcher.find()){
                String numbers = matcher.group("numbers");
                String lowerCase = matcher.group("lowerCase");
                String upperCase = matcher.group("upperCase");
                String symbols = matcher.group("symbols");
                validPass.append(numbers);
                validPass.append(lowerCase);
                validPass.append(upperCase);
                validPass.append(symbols);
                System.out.printf("Password: %s%n",validPass);
            }else{
                System.out.println("Try another password!");
            }
        }

    }
}

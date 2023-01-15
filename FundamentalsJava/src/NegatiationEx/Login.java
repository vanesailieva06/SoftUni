package NegatiationEx;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String pass = scanner.nextLine();
        int count = 0;
        boolean blockedUser = false;
        boolean loggedUser = false;
        String correctPass = "";
        for (int i = username.length() - 1; i >= 0 ; i--) {
            char symbol = username.charAt(i);
            correctPass += symbol;
        }
        while (!blockedUser && !loggedUser){
            if (pass.equals(correctPass)){
                System.out.printf("User %s logged in.%n", username);
                loggedUser = true;
                continue;
            }else {
                count++;
                if (count == 4){
                    System.out.printf("User %s blocked!%n", username);
                    blockedUser = true;
                    continue;
                }else {
                    System.out.println("Incorrect password. Try again.");
                }
            }
            pass = scanner.nextLine();
        }
    }
}

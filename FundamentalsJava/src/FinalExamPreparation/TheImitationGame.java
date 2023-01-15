package FinalExamPreparation;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String encryptedMessage = scanner.nextLine();
        StringBuilder messageBuilder = new StringBuilder(encryptedMessage);
        String command = scanner.nextLine();
        while (!command.equals("Decode")){
            //•	"Move {number of letters}":
            //o	Moves the first n letters to the back of the string
            if (command.contains("Move")) {
                int n = Integer.parseInt(command.split("\\|")[1]);
                String substring = messageBuilder.substring(0, n);
                encryptedMessage = messageBuilder.toString().replace(substring, "");
                messageBuilder = new StringBuilder(encryptedMessage);
                messageBuilder.insert(messageBuilder.length() , substring);
            } else if (command.contains("Insert")) {
                int index = Integer.parseInt(command.split("\\|")[1]);
                String value = command.split("\\|")[2];
                messageBuilder.insert(index, value);
            } else if (command.contains("ChangeAll")) {
                String substring = command.split("\\|")[1];
                String replacement = command.split("\\|")[2];
                encryptedMessage = messageBuilder.toString().replaceAll(substring, replacement);
                messageBuilder = new StringBuilder(encryptedMessage);
            }
            command = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s", messageBuilder);

    }
}

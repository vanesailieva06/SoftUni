package FinalExamPreparation;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String rawPassword = scanner.nextLine();
        String command = scanner.nextLine();
        StringBuilder passBuilder = new StringBuilder(rawPassword);
        while (!command.equals("Done")){
            if (command.equals("TakeOdd")){
                StringBuilder newPassBuilder = new StringBuilder();
                //o	 Takes only the characters at odd indices and concatenates
                // them to obtain the new raw password and then prints it
                for (int i = 0; i < rawPassword.length(); i++) {
                    char symbol = rawPassword.charAt(i);
                    String symbolStr = symbol + "";
                        if (i % 2 == 1) {
                            newPassBuilder.append(rawPassword.charAt(i));
                            passBuilder = newPassBuilder;
                        }
                }
            } else if (command.contains("Cut")) {
                //•	Cut {index} {length}""
                int index = Integer.parseInt(command.split(" ")[1]);
                int length = Integer.parseInt(command.split(" ")[2]);
                passBuilder.delete(index, index + length);
                //o	Gets the substring with the given length starting from the given index from the password
                // and removes its first occurrence, then prints the password on the console.
                //o	The given index and the length will always be valid.
            }else if (command.contains("Substitute")){
                //•	"Substitute {substring} {substitute}"
                //o	If the raw password contains the given substring,
                // replaces all of its occurrences with the substitute text given and prints the result.
                //o	If it doesn't, prints "Nothing to replace!".
                String substring = command.split(" ")[1];
                String substrate = command.split(" ")[2];
                if (passBuilder.toString().contains(substring)){
                    rawPassword = passBuilder.toString().replaceAll(substring, substrate);
                    passBuilder = new StringBuilder(rawPassword);
                }else{
                    System.out.println("Nothing to replace!");
                    command = scanner.nextLine();
                    continue;
                }
            }
            System.out.println(passBuilder);
            command = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", passBuilder.toString());
    }
}

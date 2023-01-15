package FinalExamPreparation;

import java.util.Locale;
import java.util.Scanner;

public class ActivationKeysForLater {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String activationKey = scanner.nextLine();
        String command = scanner.nextLine();
        while(!command.equals("Generate")){
            //•	"Contains>>>{substring}":
            //o	If the raw activation key contains the given substring, prints: "{raw activation key} contains {substring}".
            //o	Otherwise, prints: "Substring not found!"
            if (command.contains("Contains")) {
                String substring = command.split(">>>")[1];
                if (activationKey.contains(substring)) {
                    System.out.printf("%s contains %s%n", activationKey, substring);
                } else {
                    System.out.println("Substring not found!");
                    command = scanner.nextLine();
                    continue;
                }
            }else if (command.contains("Flip")){
                //•	"Flip>>>Upper/Lower>>>{startIndex}>>>{endIndex}":
                //o	Changes the substring between the given indices (the end index is exclusive) to upper or lower case and then prints the activation key.
                //o	All given indexes will be valid.
                String upperOrLower = command.split(">>>")[1];
                int startIndex = Integer.parseInt(command.split(">>>")[2]);
                int endIndex = Integer.parseInt(command.split(">>>")[3]);
                String substring = activationKey.substring(startIndex, endIndex);
                if (upperOrLower.equals("Upper")) {
                    activationKey = activationKey.replace(substring, substring.toUpperCase(Locale.ROOT));
                }else if (upperOrLower.equals("Lower")){
                    activationKey = activationKey.replace(substring, substring.toLowerCase(Locale.ROOT));
                }
            }else if (command.contains("Slice")){
                //•	"Slice>>>{startIndex}>>>{endIndex}":
                //o	Deletes the characters between the start and end indices (the end index is exclusive) and prints the activation key.
                //o	Both indices will be valid.
                int startIndex = Integer.parseInt(command.split(">>>")[1]);
                int endIndex = Integer.parseInt(command.split(">>>")[2]);
                String substring = activationKey.substring(startIndex, endIndex);
                activationKey = activationKey.replace(substring, "");
            }
            System.out.println(activationKey);
            command = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", activationKey);
    }
}

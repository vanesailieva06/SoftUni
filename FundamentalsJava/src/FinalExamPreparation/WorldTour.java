package FinalExamPreparation;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String stops = scanner.nextLine();
        StringBuilder stopsBuilder = new StringBuilder(stops);
        String command = scanner.nextLine();
        String replaceStop = "";
        while(!command.equals("Travel")){
            if (command.contains("Add Stop")) {
                //•	"Add Stop:{index}:{string}":
                //o	Insert the given string at that index only if the index is valid
                int index = Integer.parseInt(command.split(":")[1]);
                String newStop = command.split(":")[2];
                if (isValidIndex(index,stopsBuilder)){
                    stopsBuilder.insert(index, newStop);
                }
            } else if (command.contains("Remove Stop")) {
                //o	Remove the elements of the string from the starting index to the end index (inclusive)
                // if both indices are valid
                //•	"Remove Stop:{start_index}:{end_index}"
                int startIndex = Integer.parseInt(command.split(":")[1]);
                int endIndex = Integer.parseInt(command.split(":")[2]);
                if (isValidIndex(startIndex,stopsBuilder) && isValidIndex(endIndex, stopsBuilder)){
                    stopsBuilder.delete(startIndex, endIndex + 1);
                }
            } else if (command.contains("Switch")) {
                //•	"Switch:{old_string}:{new_string}":
                //o	If the old string is in the initial string, replace it with the new one (all occurrences)
                String oldString = command.split(":")[1];
                String newString = command.split(":")[2];
                if (stopsBuilder.toString().contains(oldString)) {
                    replaceStop = stopsBuilder.toString().replace(oldString,newString);
                    stopsBuilder = new StringBuilder(replaceStop);

                }
            }
            System.out.println(stopsBuilder.toString());
            command = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", stopsBuilder.toString());
    }
    public static boolean isValidIndex(int index, StringBuilder builder){
        return index >= 0 && index <= builder.length() - 1;
    }
}

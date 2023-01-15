package FinalExam;

import java.util.Locale;
import java.util.Scanner;

public class HogwartsEx1 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String spell = scanner.nextLine();
        String command = scanner.nextLine();
        //StringBuilder spellBuilder = new StringBuilder(spell);
        while(!command.equals("Abracadabra")){
            if (command.equals("Abjuration")){
               spell = spell.toUpperCase(Locale.ROOT);
                System.out.println(spell);
            }else if (command.equals("Necromancy")){
                spell = spell.toLowerCase(Locale.ROOT);
                System.out.println(spell);
            }else if (command.contains("Illusion")){
                int index = Integer.parseInt(command.split(" ")[1]);
                String letter = command.split(" ")[2];
                if (index >= 0 && index <= spell.length() - 1){
                    char oldLetter = spell.charAt(index);
                    String oldLetterStr = oldLetter + "";
                    spell = spell.replaceFirst(oldLetterStr, letter);
                    System.out.println("Done!");
                }else{
                    System.out.println("The spell was too weak.");
                }
            }else if (command.contains("Divination")){
                String firstSubstring = command.split(" ")[1];
                String secondSubstring = command.split(" ")[2];
                if (spell.contains(firstSubstring)){
                    spell = spell.replaceAll(firstSubstring, secondSubstring);
                    System.out.println(spell);
                }
            }else if (command.contains("Alteration")){
                String substring = command.split(" ")[1];
                if (spell.contains(substring)){
                    spell = spell.replace(substring, "");
                    System.out.println(spell);
                }
            }else{
                System.out.println("The spell did not work!");
            }
            command = scanner.nextLine();
        }
    }
}

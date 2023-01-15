package LIstEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countInputs = Integer.parseInt(scanner.nextLine());
        List<String> guests = new ArrayList<>();
        for (int i = 1; i <= countInputs ; i++) {
            String command = scanner.nextLine();
            List<String> partsOfCommand =
                    Arrays.stream(command.split(" "))
                            .collect(Collectors.toList());
            String name = partsOfCommand.get(0);
            if (partsOfCommand.size() == 3){ //going
                if (guests.contains(name)){
                    System.out.printf("%s is already in the list!%n", name);
                }else{
                    guests.add(name);
                }
            }else{
                if (!guests.contains(name)){
                    System.out.printf("%s is not in the list!%n", name);
                }else{
                    guests.remove(name);
                }
            }
        }
        for (String name : guests){
            System.out.println(name + " ");
        }
    }
}

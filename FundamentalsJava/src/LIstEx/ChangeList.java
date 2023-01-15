package LIstEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("end")){
               String command = input.split(" ")[0];
               if (command.equals("Delete")){
                   int element = Integer.parseInt(input.split(" ")[1]);
                   List<Integer> listRemove = new ArrayList<>(Arrays.asList(element));
                   numList.removeAll(listRemove);
               }else if (command.equals("Insert")){
                   int element = Integer.parseInt(input.split(" ")[1]);
                   int position = Integer.parseInt(input.split(" ")[2]);
                   numList.add(position, element);
               }
               input = scanner.nextLine();
        }
        for (int number : numList){
            System.out.print(number + " ");
        }
    }
}

package MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        String input = scanner.nextLine();
        while(!input.equals("End")){
            String command = input.split(" ")[0];
            int index = Integer.parseInt(input.split(" ")[1]);
            int value = Integer.parseInt(input.split(" ")[2]);
            //shoot -> изваждаме число и дадената сила(РАБОТИ АКО РАЗЛИКАТА Е > 0
            //add -> insert
            //strike -> remove radius = 2 * value + 1(target)
            if (command.equals("Shoot")){
                if (isValidIndex(numList,index)){
                    int newNum = numList.get(index) - value;
                    if (newNum > 0){
                        numList.set(index, newNum);
                    }else{
                        numList.remove(index);
                    }
                }
            }else if (command.equals("Add")){
                if (isValidIndex(numList,index)){
                    numList.add(index, value);
                }else {
                    System.out.println("Invalid placement!");
                }
            }else if (command.equals("Strike")){
                int radius = 2 * value + 1;
                boolean isValidStrike = index + value <= numList.size() - 1 &&
                        index - value >= 0 && index <= numList.size() - 1;
                if (!isValidStrike){
                    System.out.println("Strike missed!");
                }else{
                    for (int i = 0; i < radius; i++) {
                        numList.remove(index - value);
                    }
                }
            }
            input = scanner.nextLine();
        }
            String numString = numList.toString();
            System.out.println(numList.toString().replace("[", "")
                    .replace("]", "").replace(",", "|")
                    .replace(" ", ""));

    }

    public static boolean isValidIndex(List<Integer> numList, int index){
        return index <= numList.size() - 1 && numList.size() - 1 >= index;
    }
}

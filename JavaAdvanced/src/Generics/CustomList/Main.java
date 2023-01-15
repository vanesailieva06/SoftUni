package Generics.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input= scanner.nextLine();
        CustomList<String> list = new CustomList<>();
        while (!input.equals("END")){
            String command = input.split(" ")[0];
            String element;
            switch (command){
                //•	Add {element} - Adds the given element to the end of the list.
                //•	Remove {index} - Removes the element at the given index.
                //•	Contains {element} - Prints if the list contains the given element (true or false).
                //•	Swap {index1} {index2} - Swaps the elements at the given indexes.
                //•	Greater {element} - Counts the elements that are greater than the given element and prints their count
                //•	Max - Prints the maximum element in the list.
                //•	Min - Prints the minimum element in the list.
                //•	Print - Prints all elements in the list, each on a separate line.
                case"Add":
                    element = input.split(" ")[1];
                    list.add(element);
                    break;
                case"Remove":
                    int index = Integer.parseInt(input.split(" ")[1]);
                    list.remove(index);
                    break;
                case"Contains":
                    element = input.split(" ")[1];
                    System.out.println(list.contains(element));
                    break;
                case"Swap":
                    int firstIndex = Integer.parseInt(input.split(" ")[1]);
                    int secondIndex = Integer.parseInt(input.split(" ")[2]);
                    list.swap(firstIndex,secondIndex);
                    break;
                case"Greater":
                    element = input.split(" ")[1];
                    System.out.println(list.countGreaterThan(element));
                    break;
                case"Max":
                    System.out.println(list.getMax());
                    break;
                case"Min":
                    System.out.println(list.getMin());
                    break;
                case"Print":
                    System.out.println(list);
                    break;
            }
            input = scanner.nextLine();
        }
    }
}

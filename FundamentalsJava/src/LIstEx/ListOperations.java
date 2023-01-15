package LIstEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("End")){
            String operation = input.split(" ")[0];
            //•	Add {number} - add number at the end
            //•	Insert {number} {index} - insert number at given index
            //•	Remove {index} - remove that index
            //•	Shift left {count} - first number becomes last 'count' times
            //•	Shift right {count} - last number becomes first 'count' times
            if (operation.equals("Add")){
                int number = Integer.parseInt(input.split(" ")[1]);
                numList.add(number);
            }else if(operation.equals("Insert")){
                int number = Integer.parseInt(input.split(" ")[1]);
                int index = Integer.parseInt(input.split(" ")[2]);
                int sizeList = numList.size();
                if (isValidIndex(index,sizeList)){
                    numList.add(index, number);
                }else{
                    System.out.println("Invalid index");
                }
            }else if(operation.equals("Remove")){
                int index = Integer.parseInt(input.split(" ")[1]);
                int sizeList = numList.size();
                if (isValidIndex(index,sizeList)){
                    numList.remove(index);
                }else{
                    System.out.println("Invalid index");
                }

            }else if(operation.equals("Shift")){
                String direction = input.split(" ")[1];
                int count = Integer.parseInt(input.split(" ")[2]);
                if (direction.equals("left")){
                    for (int i = 1; i <= count ; i++) {
                        int firstNum = numList.get(0);//1 2 3 4 5
                        numList.add(numList.size() , firstNum);// 1,2,3,4,5,1
                        numList.remove(0);

                    }
                }else if (direction.equals("right")){
                    for (int i = 1; i <= count ; i++) {
                        int lastNum = numList.get(numList.size() - 1);//1 2 3 4 5
                        numList.add(0, lastNum);// 5 1 2 3 4 5
                        numList.remove(numList.size() - 1);
                    }
                }

            }
            input = scanner.nextLine();
        }
        for (int num : numList){
            System.out.print(num + " ");
        }

    }
    //if the index given may be outside of the bounds of the array- method
    public static boolean isValidIndex(int index,int size){
        return size >= 0 && index <= size;
    }

}

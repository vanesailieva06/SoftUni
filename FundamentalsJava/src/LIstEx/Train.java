package LIstEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagonList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("end")){
            String add = input.split(" ")[0];
            if (add.equals("Add")){
                int addedWagon = Integer.parseInt(input.split(" ")[1]);
                wagonList.add(addedWagon);
            }else {
                int addedPassengers = Integer.parseInt(input.split(" ")[0]);
                for (int i = 0; i < wagonList.size(); i++) {
                    int currentWagon = wagonList.get(i);
                    if(currentWagon + addedPassengers <= maxCapacity) {
                        wagonList.set(i, currentWagon + addedPassengers);
                        break;
                    }

                }
            }
            input = scanner.nextLine();
        }
        for (int num : wagonList){
            System.out.print(num + " ");
        }
    }
}

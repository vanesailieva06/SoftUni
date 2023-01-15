package LIstEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        List<Integer> bombNumAndPower = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        for (int i = 0; i < numList.size(); i++) {
            int bombNumber = bombNumAndPower.get(0);
            int power = bombNumAndPower.get(1);
            numList.remove(bombNumber);
            for (int j = 1; j <= power; j++){
                numList.remove(bombNumber - 1);
                numList.remove(bombNumber + 1);
            }
        }
        System.out.println(numList);
    }
}

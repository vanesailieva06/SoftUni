package LIstEx;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstPlayer = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondPlayer = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int sum = 0;

        while (firstPlayer.size() != 0 && secondPlayer.size() != 0){
            int firstPlayerCard = firstPlayer.get(0);
            int secondPLayerCard = secondPlayer.get(0);
            if (firstPlayerCard > secondPLayerCard){
                firstPlayer.remove(0);
                firstPlayer.add(firstPlayer.size(), firstPlayerCard);
                firstPlayer.add(firstPlayer.size() , secondPLayerCard);
                secondPlayer.remove(0);
            }else if (secondPLayerCard > firstPlayerCard){
                secondPlayer.remove(0);
                secondPlayer.add(secondPlayer.size() , secondPLayerCard);
                secondPlayer.add(secondPlayer.size(), firstPlayerCard);
                firstPlayer.remove(0);
            }else if (firstEqualSecond(firstPlayerCard,secondPLayerCard)){
                firstPlayer.remove(Integer.valueOf(firstPlayerCard));
                secondPlayer.remove(Integer.valueOf(secondPLayerCard));
            }
        }
        if (firstListBigger(firstPlayer,secondPlayer)){
            for (int num : firstPlayer){
                sum += num;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        }else if (secondListBigger(firstPlayer,secondPlayer)){
            for (int num : secondPlayer){
                sum += num;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        }

    }

    public static  boolean firstEqualSecond(int first, int second){
        return first == second;
    }
    public static boolean firstListBigger(List<Integer> first, List<Integer> second){
        return first.size() > second.size();
    }
    public static boolean secondListBigger(List<Integer> first, List<Integer> second){
        return first.size() < second.size();
    }
}

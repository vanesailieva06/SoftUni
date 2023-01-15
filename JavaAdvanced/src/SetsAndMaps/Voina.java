package SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] secondPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Set<Integer> firstPlayerCards = new LinkedHashSet<>();
        Set<Integer> secondPlayerCards = new LinkedHashSet<>();
        for(int card : firstPlayer){
            firstPlayerCards.add(card);
        }
        for (int card : secondPlayer){
            secondPlayerCards.add(card);
        }
        int rounds = 50;
        for (int i = 0; i < rounds; i++) {
            if (firstPlayerCards.isEmpty() || secondPlayerCards.isEmpty()){
                continue;
            }
            int firstCard = firstPlayerCards.iterator().next();
            firstPlayerCards.remove(firstCard);
            int secondCard = secondPlayerCards.iterator().next();
            secondPlayerCards.remove(secondCard);
            if (firstCard > secondCard){
                firstPlayerCards.add(firstCard);
                firstPlayerCards.add(secondCard);
            }else if (secondCard > firstCard){
                secondPlayerCards.add(firstCard);
                secondPlayerCards.add(secondCard);
            }
        }
        System.out.println(firstPlayerCards.size() > secondPlayerCards.size() ? "First player win!" : "Second player win!");
    }
}

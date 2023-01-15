package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        String input = scanner.nextLine();
        Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .forEach(firstBoxQueue::offer);
        input = scanner.nextLine();
        Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .forEach(secondBoxStack::push);
        int lootSum = 0;
        int sum = 0;
        List<Integer> loot = new ArrayList<>();
        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int firstNum = firstBoxQueue.peek();
            int secondNum = secondBoxStack.pop();
            sum = firstNum + secondNum;
            if (sum % 2 == 0) {
                firstBoxQueue.poll();
                loot.add(sum);
            } else {
                firstBoxQueue.offer(secondNum);
            }
        }
        for (int num : loot) {
            lootSum += num;
        }

        System.out.println(firstBoxQueue.isEmpty() ? "First lootbox is empty" : "Second lootbox is empty");
        if (sum >= 100) {
            System.out.printf("Your loot was epic! Value: %d", lootSum);
        } else {
            System.out.printf("Your loot was poor... Value: %d", lootSum);
        }
    }
}

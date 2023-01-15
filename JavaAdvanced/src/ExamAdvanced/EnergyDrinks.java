package ExamAdvanced;

import java.util.*;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> caffeineStack = new ArrayDeque<>();
        ArrayDeque<Integer> energyDrinksQueue = new ArrayDeque<>();
        String input = scanner.nextLine();
        Arrays.stream(input.split(", ")).map(Integer :: parseInt)
                .forEach(caffeineStack :: push);
        input = scanner.nextLine();
        Arrays.stream(input.split(", ")).map(Integer :: parseInt)
                .forEach(energyDrinksQueue :: offer);
        int maxCaffeine = 300;
        int currentCaffeine = 0;
        while (!caffeineStack.isEmpty() && !energyDrinksQueue.isEmpty()){
            int caffeineValue = caffeineStack.peek();
            int drinkValue = energyDrinksQueue.peek();
            int sum = caffeineValue * drinkValue;
            caffeineStack.pop();
            energyDrinksQueue.poll();
            if (sum <= maxCaffeine){
                maxCaffeine -= sum;
                currentCaffeine += sum;
            }else{
                energyDrinksQueue.offer(drinkValue);
                if (currentCaffeine - 30 >= 0) {
                    currentCaffeine -= 30;
                    maxCaffeine += 30;
                }
            }
        }
        if (!energyDrinksQueue.isEmpty()){
            System.out.print("Drinks left: ");
            print(energyDrinksQueue);
        }else{
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", currentCaffeine);
    }


    public static void print(ArrayDeque<Integer> arrayDeque){
        String join = String.join(", ", arrayDeque.toString());
        System.out.println(join.replace("[","").replace("]", ""));
    }
}

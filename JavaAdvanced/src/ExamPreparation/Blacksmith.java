package ExamPreparation;

import java.util.*;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();
        String input = scanner.nextLine();
        Arrays.stream(input.split(" ")).map(Integer :: parseInt)
                .forEach(steelQueue :: offer);
        input = scanner.nextLine();
        Arrays.stream(input.split(" ")).map(Integer :: parseInt)
                .forEach(carbonStack :: push);
        Map<String, Integer> swords = new TreeMap<>();
        swords.put("Gladius", 0);
        swords.put("Shamshir", 0);
        swords.put("Katana" , 0);
        swords.put("Sabre", 0);
        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()){
            int steelValue = steelQueue.poll();
            int carbonValue = carbonStack.pop();
            int  sum = steelValue + carbonValue;
            if (sum == 70){
                swords.put("Gladius", swords.get("Gladius") + 1);
            } else if (sum == 80) {
                swords.put("Shamshir", swords.get("Shamshir") + 1);
            } else if (sum == 90) {
                swords.put("Katana", swords.get("Katana") + 1);
            } else if (sum == 110) {
                swords.put("Sabre", swords.get("Sabre") + 1);
            }else{
                carbonStack.push(carbonValue + 5);
            }
        }
        int countOfSwords = swords.values().stream().mapToInt(Integer :: intValue).sum();
        if (countOfSwords > 0){
            System.out.printf("You have forged %d swords.%n",countOfSwords);
        }else{
            System.out.println("You did not have enough resources to forge a sword.");
        }
        if (steelQueue.isEmpty()){
            System.out.println("Steel left: none");
        }else{
            System.out.print("Steel left: ");
            print(steelQueue);
        }
        if (carbonStack.isEmpty()){
            System.out.print("Carbon left: none");
        }else{
            System.out.print("Carbon left: ");
            print(carbonStack);
        }
        for (Map.Entry<String, Integer> entry : swords.entrySet()) {
            if (entry.getValue() != 0){
                System.out.printf("%s: %d%n", entry.getKey(),entry.getValue());
            }
        }


    }
    public static void print(ArrayDeque<Integer> arrayDeque){
        String join = String.join(", ", arrayDeque.toString());
        System.out.println(join.replace("[","").replace("]", ""));
    }
}

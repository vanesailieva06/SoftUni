package AssociativeArrEx;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Double> orderSum = new LinkedHashMap<>();
        while(!input.equals("buy")){
            String product = input.split(" ")[0];
            double price = Double.parseDouble(input.split(" ")[1]);
            int quantity = Integer.parseInt(input.split(" ")[2]);
            double sum = price * quantity;
            if (orderSum.containsKey(product)){
                double currentSum = Math.abs(sum - orderSum.get(product));
                orderSum.put(product, currentSum);
                input = scanner.nextLine();
                continue;
            }
            orderSum.put(product, sum);
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Double> entry : orderSum.entrySet()) {
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue());
        }

    }
}

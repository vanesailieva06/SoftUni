package SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] values = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Map<Double, Integer> mapValues = new LinkedHashMap<>();
        for (double num : values){
            if (!mapValues.containsKey(num)){
                mapValues.put(num, 1);
            }else{
                mapValues.put(num,mapValues.get(num) + 1);
            }
        }
        for (Map.Entry<Double, Integer> entry : mapValues.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}

package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[] :: new);
        Function<Integer[], Integer> smallestNum = arr ->{
            int min = Integer.MAX_VALUE;
            for (Integer integer : arr) {
                if (integer < min) {
                    min = integer;
                }
            }
            return min;
        };
        int min = smallestNum.apply(numbers);
        System.out.println(min);
    }
}

package FunctionalProgramming;

import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer :: parseInt)
                .collect(Collectors.toList());
        Collections.reverse(numbers);
        int n = Integer.parseInt(scanner.nextLine());
        UnaryOperator<List<Integer>> correctNum = list -> list.stream().filter(e -> e % n != 0)
                .collect(Collectors.toList());
        Consumer<Integer> printer = e -> System.out.print(e + " ");
        numbers = correctNum.apply(numbers);
        numbers.forEach(printer);

    }
}

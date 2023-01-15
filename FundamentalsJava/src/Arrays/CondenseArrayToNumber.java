package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[]numArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer :: parseInt)
                .toArray();
        int[] condensed = new int[numArr.length - 1];
        int sum = 0;
        for (int i = 0;numArr.length > 1;i++){
            condensed[i] = numArr[i] + numArr[i + 1];
            numArr[i] = condensed[i];
            sum += numArr[i];
            numArr[i] = numArr[numArr.length - 1];
        }
        System.out.println(sum);
    }
}

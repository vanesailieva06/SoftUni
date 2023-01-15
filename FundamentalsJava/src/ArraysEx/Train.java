package ArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int[]numArr = new int[n];
        for (int i = 0; i < numArr.length; i++){
            int num = Integer.parseInt(scanner.nextLine());
            sum += num;
            numArr[i] = num;

        }
        System.out.println(Arrays.toString(numArr).replace("[", "").replace("]", "")
                .replace(",", ""));
        System.out.println(sum);

    }
}

package ArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[]firstArr = new int[n];
        int[]secondArr = new int[n];
        for (int i = 0; i < n; i++){
            String number = scanner.nextLine();
            String[] numArr = number.split(" ");
            int firstNum = Integer.parseInt(numArr[0]);
            int secondNum = Integer.parseInt(numArr[1]);
            if (i % 2 == 1){
                firstArr[i] = firstNum;
                secondArr[i] = secondNum;
            }else {
                secondArr[i] = firstNum;
                firstArr[i] = secondNum;
            }
        }
        System.out.println(Arrays.toString(secondArr).replace("[", "").replace("]", "")
                .replace(",", ""));
        System.out.println(Arrays.toString(firstArr).replace("[", "").replace("]", "")
                .replace(",", ""));
    }
}

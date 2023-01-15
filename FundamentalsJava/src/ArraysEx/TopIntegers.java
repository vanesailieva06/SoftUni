package ArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer :: parseInt)
                .toArray();
        for (int i = 0; i < numArr.length - 1; i++){
            int element = numArr[i];
            int lastElement = numArr[numArr.length - 1];
            for (int j = i; j <= numArr.length - 1 ; j++) {
                if (element >= numArr[j]){
                    System.out.print(element + " ");
                }
            }
        }
        //if (numArr[numArr.length - 1] > numArr[0]){
            //System.out.print(numArr[numArr.length - 1]);
        //}
    }
}

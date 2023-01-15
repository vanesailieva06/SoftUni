package ArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rotations = Integer.parseInt(scanner.nextLine());
        for (int countRotation = 1;countRotation <= rotations; countRotation++){
           int firstElement = arr[0];
           for (int i = 0;i < arr.length - 1; i++){
               arr[i] = arr[i + 1];
           }
           arr[arr.length - 1] = firstElement;
        }
        for (int elements: arr) {
            System.out.print(elements + " ");
        }
    }
}
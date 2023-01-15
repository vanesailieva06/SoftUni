package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer :: parseInt)
                .toArray();
        int evenSum = 0;
        int oddSum = 0;
        for (int numbers : numArr){
            if (numbers % 2 == 0 ){
                evenSum += numbers;
            }else{
                oddSum += numbers;
            }
        }
        System.out.println(evenSum - oddSum);
    }
}

package Arrays;

import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] elementsArr = scanner.nextLine().split(" ");

        for (int i = elementsArr.length - 1; i >= 0; i--){
            System.out.print(elementsArr[i] + " ");
        }
    }
}

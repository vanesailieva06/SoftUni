package WhaleLab;

import java.util.Scanner;

public class Sequence2KPlus1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         int n = Integer.parseInt(scanner.nextLine());
         int sum = 1;

         while (n >= sum){
             System.out.println(sum);
             sum = 2 * sum + 1;
         }

    }
}

package Test;

import java.util.Scanner;

public class GiftsFromSanta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nStreet = Integer.parseInt(scanner.nextLine());
        int mStreet = Integer.parseInt(scanner.nextLine());
        int sStreet = Integer.parseInt(scanner.nextLine());

        for (int m = mStreet; m <= mStreet; m--){
            if (m == sStreet && m % 2 == 0 && m % 3 == 0){
                break;
            }
            if (m < nStreet || m > mStreet){
                break;
            }

            if (m % 2 == 0 && m % 3 == 0){
                System.out.printf("%d ", m);
            }


        }
    }
}

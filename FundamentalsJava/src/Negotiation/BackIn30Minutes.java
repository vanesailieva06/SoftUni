package Negotiation;

import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
        int addedMinutes = minutes + 30;
        int leftMinutes = 0;
        if (addedMinutes > 59){
            hours++;
            leftMinutes = 60 - addedMinutes;
            if (hours > 23){
                hours = 0;
            }
            if (Math.abs(leftMinutes) < 10){
                System.out.printf("%d:0%d", hours, Math.abs(leftMinutes));
            }else{
                System.out.printf("%d:%d", hours, Math.abs(leftMinutes) );

            }
        }else{
            System.out.printf("%d:%d", hours, addedMinutes);
        }
    }
}

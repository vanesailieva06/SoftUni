package ConditionalStatementsEx;

import java.util.Scanner;

public class TimeWith15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
        int totalTime = hour * 60 + minutes + 15;

        hour = totalTime / 60;
        minutes = totalTime % 60;
        if(hour > 23){
            hour = 0;
        }
        if(minutes < 10){
            System.out.printf("%d:0%d", hour, minutes);
        }else{
            System.out.printf("%d:%d", hour, minutes);
        }

    }
}

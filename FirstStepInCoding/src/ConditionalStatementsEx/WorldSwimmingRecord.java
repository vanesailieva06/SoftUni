package ConditionalStatementsEx;

import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double record = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double secsForOneMeter = Double.parseDouble(scanner.nextLine());
        double neededSecs = secsForOneMeter * distance;
        double resistance = Math.floor(distance / 15)* 12.5;
        double totalTime = neededSecs + resistance;
        double neededTime = totalTime - record;
        if(totalTime < record){
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds." , totalTime);

        }else{
            System.out.printf("No, he failed! He was %.2f seconds slower." , Math.abs(neededTime));
        }

    }
}

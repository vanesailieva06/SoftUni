package Test;

import java.util.Scanner;

public class ANDProcessors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int processors = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());
        int workDays = Integer.parseInt(scanner.nextLine());

        int allHours = workers * workDays * 8;
        double processorsForAllHours = Math.floor(allHours / 3);
        double restProcessors = Math.abs(processors - processorsForAllHours);
        if (processorsForAllHours < processors){
            System.out.printf("Losses: -> %.2f BGN" , restProcessors * 110.10);
        }else{
            System.out.printf("Profit: -> %.2f BGN", restProcessors * 110.10);
        }
    }
}

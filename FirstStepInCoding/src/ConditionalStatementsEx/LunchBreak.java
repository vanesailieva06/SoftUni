package ConditionalStatementsEx;

import java.util.Scanner;

public class LunchBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String show = scanner.nextLine();
        int oneEpisode = Integer.parseInt(scanner.nextLine());
        int timeBreak = Integer.parseInt(scanner.nextLine());
        double lunch = timeBreak * 0.125;
        double relaxTime = timeBreak * 0.25;
        double timeUsed = lunch + relaxTime;
        double timeLeft = timeBreak - timeUsed;
        double neededTime = oneEpisode - timeLeft;
        if(timeLeft >= oneEpisode){
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time. " , show , Math.abs(neededTime));
        } else{
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes. " , show , Math.abs(neededTime));
        }
    }
}

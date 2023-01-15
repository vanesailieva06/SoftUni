package TestPreperation;

import java.util.Scanner;

public class FootballResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstTerm = scanner.nextLine();
        String secondTerm = scanner.nextLine();
        String thirdTerm = scanner.nextLine();

        int wonResult = 0;
        int lostResult = 0;
        int drawnResult = 0;

        char firstTermHost = firstTerm.charAt(0);
        char firstTermGuest = firstTerm.charAt(2);
         if (firstTermHost > firstTermGuest) {
             wonResult++;
         }else if(firstTermHost < firstTermGuest){
            lostResult++;
        }else{
             drawnResult++;
         }

         char secondTermHost = secondTerm.charAt(0);
         char secondTermGuest = secondTerm.charAt(2);
         if (secondTermHost > secondTermGuest){
             wonResult++;
         }else if (secondTermHost < secondTermGuest){
             lostResult++;
         }else{
             drawnResult++;
         }

         char thirdTermHost = thirdTerm.charAt(0);
         char thirdTermGuest = thirdTerm.charAt(2);

         if (thirdTermHost > thirdTermGuest){
             wonResult++;
         }else if (thirdTermHost < thirdTermGuest){
             lostResult++;
         }else{
             drawnResult++;
         }
         System.out.printf("Team won %d games.%n", wonResult);
         System.out.printf("Team lost %d games.%n", lostResult);
         System.out.printf("Drawn games: %d", drawnResult);
    }
}

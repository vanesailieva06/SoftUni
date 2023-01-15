package TextProcessingEx;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String name = scanner.nextLine();
        String[] namesArr = name.split(" ");
        String firstName = namesArr[0];
        String secondName = namesArr[1];
        int sum = 0;
        for (int i = 0; i < name.toCharArray().length; i++) {
            if ((int)firstName.charAt(i) == -1 ){
                sum += (int)secondName.charAt(i);
            }else if ((int)secondName.charAt(i) == -1 ){
                sum += (int) firstName.charAt(i);
            }
            sum += (int)firstName.charAt(i) * (int) secondName.charAt(i);


        }

        System.out.println(sum);
    }
    public static boolean isBiggerName(String first, String second){
        if (first.length() == second.length()){
            return false;
        }
        return true;
    }
}

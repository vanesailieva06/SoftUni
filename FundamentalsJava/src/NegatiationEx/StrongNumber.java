package NegatiationEx;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wholeNum = scanner.nextLine();
        int sum = 0;
        for (char numChar : wholeNum.toCharArray()){
            String numStr = numChar + "";
            int num = Integer.parseInt(numStr);
            int fact = 1;
            for (int i = 1; i <= num ; i++) {
                fact = fact * i;
            }
            sum += fact;
        }
        if(sum == Integer.parseInt(wholeNum)){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }

    }
}

package NestedLoopsLab;

import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        int lastNum = Integer.parseInt(scanner.nextLine());
        int magicNum = Integer.parseInt(scanner.nextLine());
        int trueValidation = 0;

        int falseCombination = 0;
        boolean isNegative = false;

        for (int x = firstNum; x <= lastNum ; x++){
            for (int y = firstNum; y <= lastNum ; y++){



                if (x + y != magicNum){
                    isNegative = true;
                    falseCombination ++;
                    continue;
                }
                if (x + y == magicNum){
                    trueValidation = falseCombination + 1;
                    falseCombination = trueValidation;
                }

                firstNum = x;
                lastNum = y;
                break;

            }
            if (trueValidation == falseCombination){
                break;
            }
        }
        if (firstNum + lastNum == magicNum){
            System.out.printf("Combination N:%d (%d + %d = %d)",falseCombination, firstNum , lastNum , magicNum);
        }else{
            System.out.printf("%d combinations - neither equals %d", falseCombination, magicNum);
        }
    }
}

package TextProcessingEx;

import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String numFirstStr = scanner.nextLine();
        String numSecondStr = scanner.nextLine();
        BigInteger firstNum = new BigInteger(numFirstStr);
        BigInteger secondNum = new BigInteger(numSecondStr);
        BigInteger sum = firstNum.multiply(secondNum);
        System.out.println(sum);
    }
}

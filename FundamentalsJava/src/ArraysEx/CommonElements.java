package ArraysEx;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstArr = scanner.nextLine().split(" ");
        String[] secondArr = scanner.nextLine().split(" ");
        for (String elementsSecond : secondArr){
           for (String elementsFirst : firstArr){
               if (elementsSecond.equals(elementsFirst)){
                   System.out.print(elementsSecond + " ");
               }
           }
        }
    }
}

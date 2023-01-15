package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheAngryCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> priceRating = Arrays
                    .stream(scanner.nextLine().split(", "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        int entryPoint = Integer.parseInt(scanner.nextLine());
        String typeOfItems = scanner.nextLine();
        int right = 0;
        int left = 0;
        //int sum = 0;
        for (int i = 0; i < priceRating.size(); i++) {
            int numEntry = priceRating.get(entryPoint);
            int index = entryPoint + 1;
            if (priceRating.size() - 1 < index){
                break;
            }
            if (typeOfItems.equals("cheap")){
                if (priceRating.get(i) < numEntry && i < entryPoint){
                    left += priceRating.get(i);
                }else if (priceRating.get(index) < numEntry){
                    right += priceRating.get(index);
                    priceRating.remove(index);
                }
            }else if (typeOfItems.equals("expensive")){
                if (priceRating.get(i) >= numEntry && i < entryPoint){
                    left += priceRating.get(i);
                }else if ( priceRating.get(index ) >= numEntry){
                    right += priceRating.get(index);
                    //priceRating.add(priceRating.size(),priceRating.get(entryPoint + 1 ));
                    priceRating.remove(index);
                }else if(priceRating.get(index) <= numEntry){
                    priceRating.remove(index);
                }
            }
            //sum = right + left;
        }
        if (Math.abs(left) > Math.abs(right)){
            System.out.printf("Left - %d", left);
        }else if (Math.abs(right) > Math.abs(left)){
            System.out.printf("Right - %d", right);
        }else{
            System.out.printf("Left - %d", left);
        }
    }
}

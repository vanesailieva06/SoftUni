package NegatiationEx;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        String typePeople = scanner.nextLine();
        String typeOfDay = scanner.nextLine();
        double price = 0;
        if (typePeople.equals("Business") && people >= 100){
            people = people - 10;
        }
        if (typeOfDay.equals("Friday")){
            if (typePeople.equals("Students")){
                price = 8.45 * people;
            }else if (typePeople.equals("Business")){
                price = 10.90 * people;
            }else if (typePeople.equals("Regular")){
                price = 15 * people;
            }
        }else if (typeOfDay.equals("Saturday")){
            if (typePeople.equals("Students")){
                price = 9.80 * people;
            }else if (typePeople.equals("Business")){
                price = 15.60 * people;
            }else if (typePeople.equals("Regular")){
                price = 20 * people;
            }
        }else if (typeOfDay.equals("Sunday")){
            if (typePeople.equals("Students")){
                price = 10.46 * people;
            }else if (typePeople.equals("Business")){
                price = 16 * people;
            }else if (typePeople.equals("Regular")){
                price = 22.50 * people;
            }
        }
        if (typePeople.equals("Students") && people >= 30){
            price = price - (price * 0.15);
        }else if(typePeople.equals("Regular") && people >= 10 && people <= 20){
            price = price - (price * 0.05);
        }
        System.out.printf("Total price: %.2f", price);
    }
}

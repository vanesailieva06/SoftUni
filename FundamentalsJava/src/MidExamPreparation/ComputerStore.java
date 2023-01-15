package MidExamPreparation;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double sumWithoutTaxes = 0;
        double totalTaxes = 0;
        double sumWithTaxes = 0;
        while (!input.equals("special") && !input.equals("regular")){
            double price = Double.parseDouble(input);//Всяка цена
            if (price < 0){
                System.out.println("Invalid price!");
                input = scanner.nextLine();
                continue;
            }
            double taxes = price * 0.2;// ДДС на всяка цена
            totalTaxes += taxes;//Общо ДДС
            sumWithoutTaxes += price;//таксата бес ДДС
            sumWithTaxes = sumWithoutTaxes + totalTaxes;
            input = scanner.nextLine();
        }
        //принтираме:
        //•	The receipt should be in the following format:
        //"Congratulations you've just bought a new computer!
        //Price without taxes: {total price without taxes}$
        //Taxes: {total amount of taxes}$
        //-----------
        //Total price: {total price with taxes}$"
        if (sumWithTaxes <= 0){
            System.out.println("Invalid order!");
        }else{
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", sumWithoutTaxes );
            System.out.printf("Taxes: %.2f$%n", totalTaxes);
            System.out.println("-----------");
            if (input.equals("special")){
                sumWithTaxes = sumWithTaxes * 0.90;
                System.out.printf("Total price: %.2f$", sumWithTaxes);
            }else{
                System.out.printf("Total price: %.2f$", sumWithTaxes);
            }
        }
    }
}

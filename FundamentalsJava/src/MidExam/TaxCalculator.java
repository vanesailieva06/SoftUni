package MidExam;

import java.util.Arrays;
import java.util.Scanner;

public class TaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] taxedVehicle = scanner.nextLine().split(">>");
        double totalTaxForEveryVehicle = 0;
        double totalTax = 0;
        int initialTax = 0;
        for (int i = 0; i < taxedVehicle.length; i++) {
            String carType = taxedVehicle[i].split(" ")[0];
            int taxYears = Integer.parseInt(taxedVehicle[i].split(" ")[1]);
            int travelledKm = Integer.parseInt(taxedVehicle[i].split(" ")[2]);
            if (carType.equals("family")){
                initialTax = 50;
                totalTaxForEveryVehicle = travelledKm / 3000 * 12 + (initialTax - taxYears * 5);
            }else if (carType.equals("heavyDuty")){
                initialTax = 80;
                totalTaxForEveryVehicle = travelledKm / 9000 * 14 + (initialTax - taxYears * 8);
            }else if (carType.equals("sports")){
                initialTax = 100;
                totalTaxForEveryVehicle = travelledKm / 2000 * 18 + (initialTax - taxYears * 9);
            }else{
                System.out.println("Invalid car type.");
                continue;
            }
            totalTax += totalTaxForEveryVehicle;
            System.out.printf("A %s car will pay %.2f euros in taxes.%n", carType, totalTaxForEveryVehicle);
        }
        System.out.printf("The National Revenue Agency will collect %.2f euros in taxes.", totalTax);

    }
}

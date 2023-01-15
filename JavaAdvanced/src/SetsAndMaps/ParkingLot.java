package SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbersCars = scanner.nextLine();
        Set<String>cars = new LinkedHashSet<>();
        while (!numbersCars.equals("END")){
            String direction = numbersCars.split(", ")[0];
            String carNumber = numbersCars.split(", ")[1];
            if (direction.equals("IN")){
                cars.add(carNumber);
            } else if (direction.equals("OUT")) {
                cars.remove(carNumber);
            }
            numbersCars = scanner.nextLine();
        }
        if (cars.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else{
            for (String car : cars){
                System.out.println(car);
            }
        }
    }
}

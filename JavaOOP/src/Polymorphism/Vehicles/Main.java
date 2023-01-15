package Polymorphism.Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carData = scanner.nextLine().split(" ");
        double fuelQuantity = Double.parseDouble(carData[1]);
        double fuelConsumption = Double.parseDouble(carData[2]);
        Vehicle car = new Car(fuelQuantity,fuelConsumption);
        String [] truckData = scanner.nextLine().split(" ");
        fuelQuantity = Double.parseDouble(truckData[1]);
        fuelConsumption = Double.parseDouble(truckData[2]);
        Vehicle truck = new Truck(fuelQuantity,fuelConsumption);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String command = data[0];
            String vehicle = data[1];
            switch (command){
                case "Drive":
                    double distance = Double.parseDouble(data[2]);
                    if ("Car".equals(vehicle)){
                        System.out.println(car.drive(distance));
                    }else{
                        System.out.println(truck.drive(distance));
                    }
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(data[2]);
                    if ("Car".equals(vehicle)){
                        car.refuel(liters);
                    }else{
                        truck.refuel(liters);
                    }
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }
}

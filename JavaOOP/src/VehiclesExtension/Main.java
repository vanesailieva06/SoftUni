package VehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carData = getData(scanner);
        double fuelQuantity = Double.parseDouble(carData[1]);
        double fuelConsumption = Double.parseDouble(carData[2]);
        double tankCapacity = Double.parseDouble(carData[3]);
        Vehicle car = new Car(fuelQuantity,fuelConsumption,tankCapacity);
        String[] truckData = getData(scanner);
        fuelQuantity = Double.parseDouble(truckData[1]);
        fuelConsumption = Double.parseDouble(truckData[2]);
        tankCapacity = Double.parseDouble(truckData[3]);
        Vehicle truck = new Truck(fuelQuantity,fuelConsumption,tankCapacity);
        String[] busData = getData(scanner);
        fuelQuantity = Double.parseDouble(busData[1]);
        fuelConsumption = Double.parseDouble(busData[2]);
        tankCapacity = Double.parseDouble(busData[3]);
        Vehicle bus = new Bus(fuelQuantity, fuelConsumption, tankCapacity);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = getData(scanner);
            String command = data[0];
            String vehicle = data[1];
            double distance;
            switch (command){
                case "Drive":
                    try {
                        distance = Double.parseDouble(data[2]);
                        if ("Car".equals(vehicle)) {
                            System.out.println(car.drive(distance));
                        } else if("Bus".equals(vehicle)) {
                            System.out.println(bus.drive(distance));
                        }else{
                            System.out.println(truck.drive(distance));
                        }
                    }catch (IllegalArgumentException exception){
                        System.out.println(exception.getMessage());
                    }
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(data[2]);
                    try {
                        if ("Car".equals(vehicle)) {
                            car.refuel(liters);
                        } else if ("Bus".equals(vehicle)){
                            bus.refuel(liters);
                        } else {
                            truck.refuel(liters);
                        }
                    }catch (IllegalArgumentException exception){
                        System.out.println(exception.getMessage());
                    }
                    break;
                case "DriveEmpty":
                    distance = Double.parseDouble(data[2]);
                    System.out.println(bus.driveEmpty(distance));
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }

    private static String[] getData(Scanner scanner) {
        return scanner.nextLine().split(" ");
    }
}

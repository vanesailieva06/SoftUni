package DefiningClasses.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countCars = Integer.parseInt(scanner.nextLine());
        Map<String,Car> carMap = new LinkedHashMap<>();
        int travelledKm = 0;
        for (int i = 0; i < countCars; i++) {
            String[] carData = scanner.nextLine().split(" ");
            //"{Model} {FuelAmount} {FuelCostFor1km}
            String modelCar = carData[0];
            int fuelAmount = Integer.parseInt(carData[1]);
            double fuelCostFor1Km = Double.parseDouble(carData[2]);
            Car car = new Car(modelCar,fuelAmount,fuelCostFor1Km);
            carMap.put(modelCar,car);
        }
        String command = scanner.nextLine();
        while (!command.equals("End")){
            String carName = command.split(" ")[1];
            int distance = Integer.parseInt(command.split(" ")[2]);
            Car carToDrive = carMap.get(carName);
            carToDrive.calculateTravelledFuel(distance);
            carToDrive.drive(distance);
            command = scanner.nextLine();
        }
        carMap.values().forEach(System.out::println);
    }
}

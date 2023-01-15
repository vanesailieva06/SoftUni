package FinalExamPreparation;

import java.util.*;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> carsMap = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            //"{car}|{mileage}|{fuel}"
            String typeCar = input.split("\\|")[0];
            int mileage = Integer.parseInt(input.split("\\|")[1]);
            int fuel = Integer.parseInt(input.split("\\|")[2]);
            List<Integer> list = new ArrayList<>();
            list.add(mileage);
            list.add(fuel);
            carsMap.put(typeCar, list);
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String car = command.split(" : ")[1];
            int fuel = carsMap.get(car).get(1);
            int mileage = carsMap.get(car).get(0);
            //•	"Drive : {car} : {distance} : {fuel}":
            //o	You need to drive the given distance, and you will need the given fuel to do that.
            // If the car doesn't have enough fuel, print: "Not enough fuel to make that ride"
            //o	If the car has the required fuel available in the tank,
            // increase its mileage with the given distance, decrease its fuel with the given fuel, and print:
            //"{car} driven for {distance} kilometers. {fuel} liters of fuel consumed."
            //o	You like driving new cars only, so if a car's mileage reaches 100 000 km,
            // remove it from the collection(s) and print: "Time to sell the {car}!"
            if (command.contains("Drive")) {
                int distance = Integer.parseInt(command.split(" : ")[2]);
                int currentFuel = Integer.parseInt(command.split(" : ")[3]);
                if (fuel > currentFuel) {
                    carsMap.get(car).set(1, fuel - currentFuel);
                    carsMap.get(car).set(0, mileage + distance);
                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, currentFuel);
                } else {
                    System.out.println("Not enough fuel to make that ride");
                }
                if (distance + mileage >= 100000) {
                    carsMap.remove(car);
                    System.out.printf("Time to sell the %s!%n", car);
                }
            } else if (command.contains("Refuel")) {
                //•	"Refuel : {car} : {fuel}":
                //o	Refill the tank of your car.
                //o	Each tank can hold a maximum of 75 liters of fuel,
                // so if the given amount of fuel is more than you can fit in the tank,
                // take only what is required to fill it up.
                //o	Print a message in the following format: "{car} refueled with {fuel} liters"
                int refillFuel = Integer.parseInt(command.split(" : ")[2]);
                int totalFuel = fuel + refillFuel;
                int diff = 0;
                if (totalFuel > 75) {
                    totalFuel = 75;
                    diff = totalFuel - fuel;
                } else {
                    diff = refillFuel;
                }
                carsMap.get(car).set(1,totalFuel);
                System.out.printf("%s refueled with %d liters%n", car, diff);
            } else if (command.contains("Revert")) {
                //•	"Revert : {car} : {kilometers}":
                //o	Decrease the mileage of the given car with the given kilometers
                // and print the kilometers you have decreased it with in the following format:
                //"{car} mileage decreased by {amount reverted} kilometers"
                //o	If the mileage becomes less than 10 000km after it is decreased,
                // just set it to 10 000km and
                //DO NOT print anything.
                int km = Integer.parseInt(command.split(" : ")[2]);
                if (mileage - km < 10000) {
                    carsMap.get(car).set(0, mileage = 10000);
                }else {
                    carsMap.get(car).set(0, mileage - km);
                    System.out.printf("%s mileage decreased by %d kilometers%n", car, km);
                }
            }
            command = scanner.nextLine();
        }
        for (Map.Entry<String, List<Integer>> entry : carsMap.entrySet()) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", entry.getKey(), entry.getValue().get(0)
                    , entry.getValue().get(1));
        }
    }
}

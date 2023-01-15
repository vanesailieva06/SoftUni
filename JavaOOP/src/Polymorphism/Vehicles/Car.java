package Polymorphism.Vehicles;

public class Car extends Vehicle {
    public static final double SUMMER_FUEL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        super.setFuelConsumption(getFuelConsumption() + SUMMER_FUEL_CONSUMPTION);
    }
}

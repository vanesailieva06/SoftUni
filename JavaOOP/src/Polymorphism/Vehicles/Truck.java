package Polymorphism.Vehicles;

public class Truck extends Vehicle {
    public static final double SUMMER_FUEL_CONSUMPTION = 1.6;
    public static final double REFUELED = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + SUMMER_FUEL_CONSUMPTION);

    }

    @Override
    public void refuel(double liters) {
        setFuelQuantity(getFuelQuantity() + liters * REFUELED);
    }
}

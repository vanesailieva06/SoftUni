package VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String drive(double distance) {
        double newConsumption = fuelConsumption + getSummerConsumption();
        return drivePrivate(distance, newConsumption);
    }
    public abstract double getSummerConsumption();
    public String driveEmpty(double distance){
        return drivePrivate(distance, fuelConsumption);
    }

    private String drivePrivate(double distance, double fuelConsumption) {
        double neededFuel = distance * fuelConsumption;
        if (fuelQuantity < neededFuel) {
            return getClass().getSimpleName() + " needs refueling";
        } else {
            setFuelQuantity(fuelQuantity - neededFuel);
            DecimalFormat df = new DecimalFormat("##.##");
            return String.format("%s travelled %s km", getClass().getSimpleName(), df.format(distance));
        }
    }

    public void refuel(double liters){
        if (liters + fuelQuantity > tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        if (liters <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        setFuelQuantity(getFuelQuantity() + liters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), getFuelQuantity());
    }
}

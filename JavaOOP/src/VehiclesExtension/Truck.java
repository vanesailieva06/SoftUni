package VehiclesExtension;

public class Truck extends Vehicle{
    public static final double REFUELED = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        super.setFuelConsumption(getFuelConsumption() + getSummerConsumption());

    }
    @Override
    public double getSummerConsumption(){
        return 1.6;
    }

    @Override
    public void refuel(double liters){
        if (getFuelQuantity() + liters > getFuelQuantity()){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        if (liters <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        setFuelQuantity(getFuelQuantity() + liters * REFUELED);
    }
}

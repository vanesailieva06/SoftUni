package VehiclesExtension;

public class Bus extends Vehicle{
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption,tankCapacity);
    }

    @Override
    public double getSummerConsumption(){
        return 1.4;
    }
}

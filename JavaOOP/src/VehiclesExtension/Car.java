package VehiclesExtension;

public class Car extends Vehicle{

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        super.setFuelConsumption(getFuelConsumption() + getSummerConsumption());
    }
    @Override
    public double getSummerConsumption(){
        return 0.9;
    }
}

package DefiningClasses.SpeedRacing;

public class Car {
     private String model;
     private double fuelAmount;
     private double fuelCostFor1Km;
     private int travelledDistance;

    public Car(String model, double fuelAmount, double fuelCostFor1Km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1Km = fuelCostFor1Km;
        this.travelledDistance = 0;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCostFor1Km() {
        return fuelCostFor1Km;
    }

    public int getTravelledDistance() {
        return travelledDistance;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setFuelCostFor1Km(double fuelCostFor1Km) {
        this.fuelCostFor1Km = fuelCostFor1Km;
    }

    public void setTravelledDistance(int travelledDistance) {
        this.travelledDistance = travelledDistance;
    }
    public double calculateTravelledFuel(int distance){
        return distance * this.getFuelCostFor1Km();
    }

    public boolean hasEnoughFuel(int distance){
        return fuelAmount >= calculateTravelledFuel(distance);
    }

    public void drive(int distance){
        if (this.hasEnoughFuel(distance)){
            this.setFuelAmount(this.getFuelAmount() - this.calculateTravelledFuel(distance));
            this.setTravelledDistance(this.getTravelledDistance() + distance);
        }else{
            System.out.println("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d",
                this.getModel(),this.getFuelAmount(), this.getTravelledDistance());
    }
}

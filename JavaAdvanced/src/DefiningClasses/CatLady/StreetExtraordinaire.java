package DefiningClasses.CatLady;

public class StreetExtraordinaire extends Cat{
    private double decibelsOfMeowing;

    public StreetExtraordinaire(String name, double decibelsOfMeowing) {
        super(name);
        this.decibelsOfMeowing = decibelsOfMeowing;
    }


    public double getDecibelsOfMeowing() {
        return decibelsOfMeowing;
    }

    public void setDecibelsOfMeowing(double decibelsOfMeowing) {
        this.decibelsOfMeowing = decibelsOfMeowing;
    }

    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f",getName(),decibelsOfMeowing);
    }
}

package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{

    private static final double OXYGEN = 70;
    private static final int DECREASE_OXYGEN = 5;

    public Biologist(String name) {
        super(name, OXYGEN);
    }


    @Override
    public void breath() {
        setOxygen(OXYGEN - DECREASE_OXYGEN);
    }
}

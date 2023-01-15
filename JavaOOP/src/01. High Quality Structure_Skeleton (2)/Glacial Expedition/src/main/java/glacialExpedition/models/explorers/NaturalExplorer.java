package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{

    private static final double ENERGY = 60;
    private static final double DECREASE_ENERGY = 7;

    public NaturalExplorer(String name) {
        super(name, ENERGY);
    }

    @Override
    public void search() {
        if (canSearch()) {
            if (getEnergy() - DECREASE_ENERGY < 0) {
                setEnergy(0);
            } else {
                setEnergy(getEnergy() - DECREASE_ENERGY);
            }
        }
    }
}

package fairyShop.models;

import static fairyShop.common.ExceptionMessages.*;

public class PresentImpl implements Present {

    private String name;
    private int energyRequired;
    private static final int DECREASE_ENERGY = 10;

    public PresentImpl(String name, int energyRequired) {
        setName(name);
        setEnergyRequired(energyRequired);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getEnergyRequired() {
        return energyRequired;
    }

    @Override
    public boolean isDone() {
        return energyRequired == 0;
    }

    @Override
    public void getCrafted() {
        if (energyRequired - DECREASE_ENERGY < 0){
            setEnergyRequired(0);
        }else{
            setEnergyRequired(energyRequired - DECREASE_ENERGY);
        }
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(PRESENT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEnergyRequired(int energyRequired) {
        if (energyRequired < 0){
            throw new IllegalArgumentException(PRESENT_ENERGY_LESS_THAN_ZERO);
        }
        this.energyRequired = energyRequired;
    }
}

package fairyShop.models;

import static fairyShop.common.ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO;

public class InstrumentImpl implements Instrument {

    private int power;

    private static final int DECREASE_POWER = 10;

    public InstrumentImpl(int power) {
        setPower(power);
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void use() {
        if (power - DECREASE_POWER < 0){
            setPower(0);
        }else {
            setPower(power - DECREASE_POWER);
        }
    }

    @Override
    public boolean isBroken() {
        if (power < 0) {
            setPower(0);
            return true;
        }else if (power == 0){
            return true;
        }else {
            return false;
        }
    }

    public void setPower(int power) {
        if (power < 0){
            throw new IllegalArgumentException(INSTRUMENT_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }
}

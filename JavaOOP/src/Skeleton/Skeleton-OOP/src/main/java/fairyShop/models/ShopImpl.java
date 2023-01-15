package fairyShop.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShopImpl implements Shop{

    private List<Instrument> brokenInstruments;
    private List<Instrument> instruments;

    public ShopImpl() {
        instruments = new ArrayList<>();
        brokenInstruments = new ArrayList<>();
    }

    @Override
    public void craft(Present present, Helper helper) {
        List<Instrument> validInstruments = helper.getInstruments().stream().filter(instrument -> !instrument.isBroken())
                .collect(Collectors.toList());
        setInstruments(validInstruments);
            for (Instrument instrument : validInstruments) {
                while (!present.isDone() && helper.canWork()) {
                    helper.work();
                    instrument.use();
                    present.getCrafted();
                    if (instrument.isBroken()) {
                        brokenInstruments.add(instrument);
                        helper.getInstruments().remove(instrument);
                        break;
                    }
                }
            }
       }

    @Override
    public List<Instrument> getBrokenInstruments() {
        return brokenInstruments;
    }

    @Override
    public List<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }
}

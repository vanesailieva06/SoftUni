package fairyShop.models;

import java.util.List;

public interface Shop {
    void craft(Present present, Helper helper);

    List<Instrument> getBrokenInstruments();

    List<Instrument> getInstruments();
}

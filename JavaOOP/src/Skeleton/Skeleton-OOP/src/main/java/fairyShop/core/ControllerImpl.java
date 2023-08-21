package fairyShop.core;

import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.List;
import java.util.stream.Collectors;

import static fairyShop.common.ConstantMessages.*;
import static fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private final HelperRepository helperRepository;
    private final PresentRepository presentRepository;
    private final Shop shop;
    private int craftedCount;


    public ControllerImpl() {
        helperRepository = new HelperRepository();
        presentRepository = new PresentRepository();
        shop = new ShopImpl();
    }


    @Override
    public String addHelper(String type, String helperName) {
        Helper helper;
        if (type.equals("Sleepy")) {
            helper = new Sleepy(helperName);
        } else if (type.equals("Happy")) {
            helper = new Happy(helperName);
        } else {
            throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }
        helperRepository.add(helper);
        return String.format(ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper currentHelper = helperRepository.findByName(helperName);
        Instrument instrument = new InstrumentImpl(power);
        if (currentHelper == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }
        currentHelper.getInstruments().add(instrument);
        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        presentRepository.add(present);
        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        Present currentPresent = presentRepository.findByName(presentName);
        List<Helper> validHelpers = helperRepository.getModels().values().stream().filter(helper -> helper.getEnergy() > 50)
                .collect(Collectors.toList());
        if (validHelpers == null) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }
        for (Helper helper : validHelpers) {
            shop.craft(currentPresent, helper);
        }
        StringBuilder sb = new StringBuilder();
        if (currentPresent.isDone()) {
            sb.append(String.format(PRESENT_DONE, presentName, "done"));
            craftedCount++;
        } else {
            sb.append(String.format(PRESENT_DONE, presentName, "not done"));
        }
        sb.append(String.format(COUNT_BROKEN_INSTRUMENTS, shop.getBrokenInstruments().size()));
        return sb.toString().trim();
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        //"{countCraftedPresents} presents are done!"
        //"Helpers info:"
        //"Name: {helperName1}"
        //"Energy: {helperEnergy1}"
        //"Instruments: {countInstruments} not broken left"
        sb.append(String.format("%d presents are done!",
                        craftedCount))
                .append(System.lineSeparator())
                .append("Helpers info:").append(System.lineSeparator());

        for (Helper helper : helperRepository.getModels().values()) {
            sb.append(String.format("Name: %s", helper.getName())).append(System.lineSeparator())
                    .append(String.format("Energy: %d", helper.getEnergy()))
                    .append(System.lineSeparator())
                    .append(String.format("Instruments: %d not broken left"
                            , helper.getInstruments().size()))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}

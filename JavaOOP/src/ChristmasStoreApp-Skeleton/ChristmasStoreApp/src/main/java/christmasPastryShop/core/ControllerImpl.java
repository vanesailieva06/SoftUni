package christmasPastryShop.core;

import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.interfaces.OpenBooth;
import christmasPastryShop.entities.booths.interfaces.PrivateBooth;
import christmasPastryShop.entities.cocktails.interfaces.Hibernation;
import christmasPastryShop.entities.cocktails.interfaces.MulledWine;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import christmasPastryShop.entities.delicacies.interfaces.Stolen;
import christmasPastryShop.repositories.interfaces.*;

import static christmasPastryShop.common.ExceptionMessages.BOOTH_EXIST;
import static christmasPastryShop.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static christmasPastryShop.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private final DelicacyRepository<Delicacy> delicacyRepository;
    private final CocktailRepository<Cocktail> cocktailRepository;
    private final BoothRepository<Booth> boothRepository;
    private Delicacy delicacy;
    private Cocktail cocktail;
    private Booth booth;

    private double totalIncome;


    public ControllerImpl() {
        delicacyRepository = new DelicacyRepositoryImpl();
        cocktailRepository = new CocktailRepositoryImpl();
        boothRepository = new BoothRepositoryImpl();
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        if (type.equals("Gingerbread")) {
            delicacy = new Gingerbread(name, price);
        } else if (type.equals("Stolen")) {
            delicacy = new Stolen(name, price);
        } else if (delicacyRepository.getByName(name).equals(delicacy)) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }
        delicacyRepository.add(delicacy);
        return String.format(DELICACY_ADDED, name, type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        if (type.equals("MulledWine")) {
            cocktail = new MulledWine(name, size, brand);
        } else if (type.equals("Hibernation")) {
            cocktail = new Hibernation(name, size, brand);
        } else if (cocktailRepository.getByName(name).equals(cocktail)) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        cocktailRepository.add(cocktail);
        return String.format(COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        if (type.equals("OpenBooth")) {
            booth = new OpenBooth(boothNumber, capacity);
        } else if (type.equals("PrivateBooth")) {
            booth = new PrivateBooth(boothNumber, capacity);
        } else if (boothRepository.getByNumber(boothNumber).equals(booth)) {
            throw new IllegalArgumentException(String.format(BOOTH_EXIST, boothNumber));
        }

        boothRepository.add(booth);
        return String.format(BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        String output;
        Booth filteredBooths = boothRepository.getAll().stream().filter(b -> !b.isReserved())
                .findFirst().orElse(null);
        if (filteredBooths == null) {
            output = String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        } else {
            filteredBooths.reserve(numberOfPeople);
            output = String.format(BOOTH_RESERVED, filteredBooths.getBoothNumber(), numberOfPeople);
        }
        return output;
    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth neededBooth = boothRepository.getByNumber(boothNumber);
        double boothBill = neededBooth.getBill();
        this.totalIncome += boothBill;
        return String.format(BILL, boothNumber, boothBill);

    }

    @Override
    public String getIncome() {
        return String.format(TOTAL_INCOME, totalIncome);
    }

    Object
}

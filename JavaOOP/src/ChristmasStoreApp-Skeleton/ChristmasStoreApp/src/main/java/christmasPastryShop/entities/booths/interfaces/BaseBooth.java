package christmasPastryShop.entities.booths.interfaces;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.BoothRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static christmasPastryShop.common.ExceptionMessages.*;

public abstract class BaseBooth implements Booth {

    private final Collection<Delicacy> delicacyOrders;
    private final Collection<Cocktail> cocktailOrders;
    private final int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;
    private List<Booth> reservedBooths;

    public BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        this.boothNumber = boothNumber;
        setCapacity(capacity);
        setNumberOfPeople(numberOfPeople);
        delicacyOrders = new ArrayList<>();
        cocktailOrders = new ArrayList<>();
    }


    @Override
    public int getBoothNumber() {
        return this.boothNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public boolean isReserved() {
        return price != 0;
    }

    @Override
    public double getPrice() {
        return this.pricePerPerson * numberOfPeople;
    }

    @Override
    public abstract void reserve(int numberOfPeople);

    @Override
    public double getBill() {
        return 0;
    }

    @Override
    public void clear() {
        delicacyOrders.clear();
        cocktailOrders.clear();
    }

    public void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }
}

package restaurant.entities.tables;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static restaurant.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {

    private final Collection<HealthyFood> healthyFood;
    private final Collection<Beverages> beverages;
    private final int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    public BaseTable(int number, int size, double pricePerPerson) {
        this.number = number;
        setSize(size);
        this.pricePerPerson = pricePerPerson;
        healthyFood = new ArrayList<>();
        beverages = new ArrayList<>();
    }


    @Override
    public int getTableNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int numberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

    @Override
    public abstract double allPeople();

    @Override
    public void reserve(int numberOfPeople) {
        isReservedTable = true;
        setNumberOfPeople(numberOfPeople);
        allPeople();
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        return beverages.stream().mapToDouble(Beverages::getPrice).sum() +
                healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();
    }

    @Override
    public void clear() {
        beverages.clear();
        healthyFood.clear();
        isReservedTable = false;
        allPeople = 0;
    }

    @Override
    public String tableInformation() {
        //"Table - {table number}
        //Size - {table size}
        //Type - {table type}
        //All price - {price per person for the current table}"
        String sb = String.format("Table - %d", number) + System.lineSeparator() +
                String.format("Size - %d", size) + System.lineSeparator() +
                String.format("Type - %s", getClass().getSimpleName()) +
                System.lineSeparator() +
                String.format("All price - %.2f", pricePerPerson) + System.lineSeparator();
        return sb.trim();
    }


    @Override
    public void setSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    public void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }
}

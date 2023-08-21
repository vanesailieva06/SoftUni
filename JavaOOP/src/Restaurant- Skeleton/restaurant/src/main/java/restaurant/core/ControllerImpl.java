package restaurant.core;

import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.Fresh;
import restaurant.entities.drinks.Smoothie;
import restaurant.entities.healthyFoods.Salad;
import restaurant.entities.healthyFoods.VeganBiscuits;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.tables.InGarden;
import restaurant.entities.tables.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.BeverageRepositoryImpl;
import restaurant.repositories.HealthFoodRepositoryImpl;
import restaurant.repositories.TableRepositoryImpl;
import restaurant.repositories.interfaces.*;

import static restaurant.common.ExceptionMessages.*;
import static restaurant.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private final HealthFoodRepository<HealthyFood> healthFoodRepository;
    private final BeverageRepository<Beverages> beverageRepository;
    private final TableRepository<Table> tableRepository;
    private double totalMoney;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood healthyFood = healthFoodRepository.foodByName(name);
        if (type.equals("Salad") && healthyFood == null) {
            healthyFood = new Salad(name, price);
        } else if (type.equals("VeganBiscuits") && healthyFood == null) {
            healthyFood = new VeganBiscuits(name, price);
        } else {
            healthyFood.setPrice(price);
            throw new IllegalArgumentException(String.format(FOOD_EXIST, name));
        }
        healthFoodRepository.add(healthyFood);
        return String.format(FOOD_ADDED, name);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        Beverages beverages = beverageRepository.beverageByName(name, brand);
        if (type.equals("Fresh") && beverages == null) {
            beverages = new Fresh(name, counter, brand);
        } else if (type.equals("Smoothie") && beverages == null) {
            beverages = new Smoothie(name, counter, brand);
        } else {
            beverages.setCounter(counter);
            throw new IllegalArgumentException(String.format(BEVERAGE_EXIST, name));
        }
        beverageRepository.add(beverages);
        return String.format(BEVERAGE_ADDED, type, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = tableRepository.byNumber(tableNumber);
        if (type.equals("Indoors") && table == null) {
            table = new Indoors(tableNumber, capacity);
        } else if (type.equals("InGarden") && table == null) {
            table = new InGarden(tableNumber, capacity);
        } else {
            table.setSize(capacity);
            throw new IllegalArgumentException(String.format(TABLE_IS_ALREADY_ADDED, tableNumber));
        }
        tableRepository.add(table);

        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {
        Table currentTable = tableRepository.getAllEntities().values().stream()
                .filter(table -> !table.isReservedTable() && table.getSize() >= numberOfPeople)
                .findFirst().orElse(null);
        if (currentTable == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        currentTable.reserve(numberOfPeople);
        return String.format(TABLE_RESERVED, currentTable.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table currentTable = tableRepository.byNumber(tableNumber);
        HealthyFood currentFood = healthFoodRepository.foodByName(healthyFoodName);
        if (currentTable == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        } else if (currentFood == null) {
            return String.format(NONE_EXISTENT_FOOD, healthyFoodName);
        }
        currentTable.orderHealthy(currentFood);
        return String.format(FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Table currentTable = tableRepository.byNumber(tableNumber);
        Beverages currentBeverage = beverageRepository.beverageByName(name, brand);
        if (currentTable == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        } else if (currentBeverage == null) {
            return String.format(NON_EXISTENT_DRINK, name, brand);
        }
        currentTable.orderBeverages(currentBeverage);
        return String.format(BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        Table currentTable = tableRepository.byNumber(tableNumber);
        double bill = currentTable.bill() + currentTable.allPeople();
        totalMoney += bill;
        currentTable.clear();
        return String.format(BILL, tableNumber, bill);
    }


    @Override
    public String totalMoney() {
        return String.format(TOTAL_MONEY, totalMoney);
    }
}

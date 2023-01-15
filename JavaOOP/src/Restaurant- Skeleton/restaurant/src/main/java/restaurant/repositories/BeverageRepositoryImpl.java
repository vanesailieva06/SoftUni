package restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.repositories.interfaces.BeverageRepository;
import restaurant.repositories.interfaces.Repository;

import java.util.*;

public class BeverageRepositoryImpl implements Repository<Beverages>, BeverageRepository<Beverages> {

    private Map<String, Beverages> entities;

    public BeverageRepositoryImpl() {
        entities = new LinkedHashMap<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return entities.values().stream().filter(beverages -> beverages.getName().equals(drinkName) && beverages.getBrand().equals(drinkBrand))
                .findFirst().orElse(null);
    }


    @Override
    public Map<String, Beverages> getAllEntities() {
        return Collections.unmodifiableMap(entities);
    }

    @Override
    public void add(Beverages entity) {
       entities.put(entity.getName(), entity);
    }
}

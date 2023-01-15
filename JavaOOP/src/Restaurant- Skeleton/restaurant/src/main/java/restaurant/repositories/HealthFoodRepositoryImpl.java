package restaurant.repositories;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.repositories.interfaces.HealthFoodRepository;
import restaurant.repositories.interfaces.Repository;

import java.util.*;

public class HealthFoodRepositoryImpl implements Repository<HealthyFood>, HealthFoodRepository<HealthyFood> {

    private Map<String, HealthyFood> entities;

    public HealthFoodRepositoryImpl() {
        entities = new LinkedHashMap<>();
    }

    @Override
    public HealthyFood foodByName(String name) {
        return entities.values().stream().filter(food -> food.getName().equals(name))
                .findFirst().orElse(null);
    }


    @Override
    public Map<String, HealthyFood> getAllEntities() {
        return Collections.unmodifiableMap(entities);
    }

    @Override
    public void add(HealthyFood entity) {
        entities.put(entity.getName(), entity);
    }
}

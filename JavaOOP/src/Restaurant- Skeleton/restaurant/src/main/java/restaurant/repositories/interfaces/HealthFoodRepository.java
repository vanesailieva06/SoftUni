package restaurant.repositories.interfaces;

import java.util.Map;

public interface HealthFoodRepository<T> extends Repository<T> {
    T foodByName(String name);
    Map<String, T> getAllEntities();
}

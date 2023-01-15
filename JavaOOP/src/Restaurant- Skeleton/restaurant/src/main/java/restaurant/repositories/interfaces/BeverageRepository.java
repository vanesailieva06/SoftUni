package restaurant.repositories.interfaces;

import java.util.Map;

public interface BeverageRepository<T> extends Repository<T> {
    T beverageByName(String drinkName,String drinkBrand);
    Map<String, T> getAllEntities();
}

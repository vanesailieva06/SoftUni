package fairyShop.repositories;

import java.util.Collection;
import java.util.Map;

public interface Repository<T> {
    Map<String, T> getModels();

    void add(T model);

    boolean remove(T model);

    T findByName(String name);
}

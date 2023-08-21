package restaurant.repositories.interfaces;

import java.util.Map;

public interface TableRepository<T> extends Repository<T> {
    T byNumber(int number);

    Map<Integer, T> getAllEntities();
}

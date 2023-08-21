package restaurant.repositories;

import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.Repository;
import restaurant.repositories.interfaces.TableRepository;

import java.util.*;

public class TableRepositoryImpl implements Repository<Table>, TableRepository<Table> {

    private final Map<Integer, Table> entities;

    public TableRepositoryImpl() {
        entities = new LinkedHashMap<>();
    }


    @Override
    public Map<Integer, Table> getAllEntities() {
        return Collections.unmodifiableMap(entities);
    }

    @Override
    public void add(Table entity) {
        entities.put(entity.getTableNumber(), entity);
    }

    @Override
    public Table byNumber(int number) {
        return entities.values().stream().filter(table -> table.getTableNumber() == number)
                .findFirst().orElse(null);
    }
}

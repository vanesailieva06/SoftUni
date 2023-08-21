package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.ArrayList;
import java.util.Collection;

public class ExplorerRepository implements Repository<Explorer> {

    private final Collection<Explorer> explorers;

    public ExplorerRepository() {
        explorers = new ArrayList<>();
    }

    @Override
    public Collection<Explorer> getCollection() {
        return explorers;
    }

    @Override
    public void add(Explorer entity) {
        explorers.add(entity);
    }

    @Override
    public boolean remove(Explorer entity) {
        return explorers.remove(entity);
    }

    @Override
    public Explorer byName(String name) {
        return explorers.stream().filter(explorer -> explorer.getName().equals(name))
                .findFirst().orElse(null);
    }
}


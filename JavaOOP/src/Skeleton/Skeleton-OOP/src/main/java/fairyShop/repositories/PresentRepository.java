package fairyShop.repositories;

import fairyShop.models.Present;

import java.util.*;

public class PresentRepository implements Repository<Present> {

    private Map<String, Present> presents;

    public PresentRepository() {
        presents = new LinkedHashMap<>();
    }

    @Override
    public Map<String, Present> getModels() {
        return Collections.unmodifiableMap(presents);
    }

    @Override
    public void add(Present model) {
        presents.put(model.getName(), model);
    }

    @Override
    public boolean remove(Present model) {
        return presents.remove(model.getName(), model);
    }

    @Override
    public Present findByName(String name) {
        return presents.values().stream().filter(present -> present.getName().equals(name))
                .findFirst().orElse(null);
    }
}

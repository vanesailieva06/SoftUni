package fairyShop.repositories;

import fairyShop.models.Helper;

import java.util.*;

public class HelperRepository implements Repository<Helper> {

    private final Map<String, Helper> helpers;

    public HelperRepository() {
        helpers = new LinkedHashMap<>();
    }

    @Override
    public Map<String, Helper> getModels() {
        return Collections.unmodifiableMap(helpers);
    }

    @Override
    public void add(Helper model) {
        helpers.put(model.getName(), model);
    }

    @Override
    public boolean remove(Helper model) {
        return helpers.remove(model.getName(), model);
    }

    @Override
    public Helper findByName(String name) {
        return helpers.values().stream().filter(helper -> helper.getName().equals(name))
                .findFirst().orElse(null);
    }
}

package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

public class DelicacyRepositoryImpl implements Repository<Delicacy>, DelicacyRepository<Delicacy> {

    private final Collection<Delicacy> models;

    public DelicacyRepositoryImpl() {
        models = new ArrayList<>();
    }

    @Override
    public Delicacy getByName(String name) {
        return models.stream().filter(d -> d.getName().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public Collection<Delicacy> getAll() {
        return this.models;
    }

    @Override
    public void add(Delicacy delicacy) {
        models.add(delicacy);
    }
}

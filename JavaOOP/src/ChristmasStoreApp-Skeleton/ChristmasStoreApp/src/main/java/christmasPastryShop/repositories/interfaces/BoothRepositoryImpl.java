package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.booths.interfaces.Booth;

import java.util.Collection;

public class BoothRepositoryImpl implements Repository<Booth>, BoothRepository<Booth>{

    private Collection<Booth> models;


    @Override
    public Booth getByNumber(int number) {
        return models.stream().filter(b -> b.getBoothNumber() == number)
                .findFirst().orElse(null);
    }

    @Override
    public Collection<Booth> getAll() {
        return this.models;
    }

    @Override
    public void add(Booth booth) {
        models.add(booth);
    }
}

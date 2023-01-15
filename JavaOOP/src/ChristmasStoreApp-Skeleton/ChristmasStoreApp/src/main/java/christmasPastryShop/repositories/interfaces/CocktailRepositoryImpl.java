package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;

import java.util.Collection;

public class CocktailRepositoryImpl implements Repository<Cocktail>, CocktailRepository<Cocktail> {

    private Collection<Cocktail> models;

    @Override
    public Cocktail getByName(String name) {
        return models.stream().filter(c -> c.getName().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public Collection<Cocktail> getAll() {
        return this.models;
    }

    @Override
    public void add(Cocktail cocktail) {
        models.add(cocktail);
    }
}

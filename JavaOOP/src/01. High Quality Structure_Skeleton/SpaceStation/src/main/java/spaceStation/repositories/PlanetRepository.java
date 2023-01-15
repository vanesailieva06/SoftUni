package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlanetRepository implements Repository<Planet>{

    private List<Planet> planets;

    public PlanetRepository() {
        planets = new ArrayList<>();
    }

    @Override
    public List<Planet> getModels() {
        return planets;
    }

    @Override
    public void add(Planet model) {
        planets.add(model);
    }

    @Override
    public boolean remove(Planet model) {
        return planets.remove(model);
    }

    @Override
    public Planet findByName(String name) {
        return planets.stream().filter(p -> p.getName().equals(name))
                .findFirst().orElse(null);
    }
}

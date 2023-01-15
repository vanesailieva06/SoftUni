package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AstronautRepository implements Repository<Astronaut>{

    private List<Astronaut> astronauts;

    public AstronautRepository() {
        astronauts = new ArrayList<>();
    }


    @Override
    public List<Astronaut> getModels() {
        return astronauts;
    }

    @Override
    public void add(Astronaut model) {
        astronauts.add(model);
    }

    @Override
    public boolean remove(Astronaut model) {
        return astronauts.remove(model);
    }

    @Override
    public Astronaut findByName(String name) {
        return astronauts.stream().filter(a -> a.getName().equals(name))
                .findFirst().orElse(null);
    }
}

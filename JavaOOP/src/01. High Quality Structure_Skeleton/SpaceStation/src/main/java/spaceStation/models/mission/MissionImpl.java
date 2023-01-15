package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MissionImpl implements Mission {

    private Planet planet;
    private List<Astronaut> astronauts;

    public MissionImpl() {
        astronauts = new ArrayList<>();
    }

    @Override
    public void explore(Planet planet, List<Astronaut> astronauts) {
        List<Astronaut> validAstronaut = astronauts.stream().filter(Astronaut::canBreath).collect(Collectors.toList());
        setAstronauts(validAstronaut);
        for (Astronaut astronaut : validAstronaut) {
            for (String item : planet.getItems()) {
                astronaut.breath();
                if (!astronaut.canBreath()){
                    validAstronaut.remove(astronaut);
                    break;
                }
                astronaut.getBag().getItems().add(item);
                List<String> items = planet.getItems();
                items.remove(item);
            }
        }
    }

    @Override
    public List<Astronaut> getAstronauts() {
        return astronauts;
    }

    public void setAstronauts(List<Astronaut> astronauts) {
        this.astronauts = astronauts;
    }
}

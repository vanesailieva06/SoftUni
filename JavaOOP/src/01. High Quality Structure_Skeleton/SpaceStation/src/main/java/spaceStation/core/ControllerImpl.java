package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private Mission mission;
    private int exploredPlanets;

    public ControllerImpl() {
        astronautRepository = new AstronautRepository();
        planetRepository = new PlanetRepository();
        mission = new MissionImpl();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        if (type.equals("Biologist")){
            astronaut = new Biologist(astronautName);
        }else if (type.equals("Geodesist")){
            astronaut = new Geodesist(astronautName);
        }else if (type.equals("Meteorologist")){
            astronaut = new Meteorologist(astronautName);
        }else{
            throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }
        astronautRepository.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        planetRepository.add(planet);
        planet.setItems(Arrays.asList(items));
        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        if (astronautRepository.findByName(astronautName) == null){
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        Astronaut currentAstronaut = astronautRepository.findByName(astronautName);
        astronautRepository.remove(currentAstronaut);
        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        List<Astronaut> validAstronauts = astronautRepository.getModels().stream().filter(a -> a.getOxygen() > 60)
                .collect(Collectors.toList());
        if (validAstronauts == null){
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        Planet currentPlanet = planetRepository.findByName(planetName);
        mission.explore(currentPlanet, validAstronauts);
        exploredPlanets++;
        int deadAstronautsCount = validAstronauts.size() - mission.getAstronauts().size();
        return String.format(PLANET_EXPLORED, planetName, deadAstronautsCount);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(REPORT_PLANET_EXPLORED, exploredPlanets)).append(System.lineSeparator())
                .append(REPORT_ASTRONAUT_INFO).append(System.lineSeparator());
        for (Astronaut astronaut : astronautRepository.getModels()) {
            Collection<String> itemsBag = astronaut.getBag().getItems();
                    sb.append(String.format(REPORT_ASTRONAUT_OXYGEN, astronaut.getOxygen()))
                    .append(System.lineSeparator())
                    .append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, itemsBag.isEmpty() ? "none" :
                    String.join(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, itemsBag.toArray(String[] :: new))))
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}

package spaceStation.models.planets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static spaceStation.common.ExceptionMessages.PLANET_NAME_NULL_OR_EMPTY;

public  class PlanetImpl implements Planet {

    private String name;
    private List<String> items;

    public PlanetImpl(String name) {
        setName(name);
        items = new ArrayList<>();
    }


    @Override
    public List<String> getItems() {
        return items;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(PLANET_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public void setItems(List<String> items) {
        this.items = items;
    }
}

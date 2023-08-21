package glacialExpedition.repositories;

import glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;

public class StateRepository implements Repository<State> {

    private final Collection<State> states;

    public StateRepository() {
        states = new ArrayList<>();
    }


    @Override
    public Collection<State> getCollection() {
        return states;
    }

    @Override
    public void add(State entity) {
        states.add(entity);
    }

    @Override
    public boolean remove(State entity) {
        return states.remove(entity);
    }

    @Override
    public State byName(String name) {
        return states.stream().filter(state -> state.getName().equals(name))
                .findFirst().orElse(null);
    }
}

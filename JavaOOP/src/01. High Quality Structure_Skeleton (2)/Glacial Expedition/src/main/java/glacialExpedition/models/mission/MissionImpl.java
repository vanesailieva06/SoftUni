package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MissionImpl implements Mission{


    private Collection<Explorer> explorers;


    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        List<Explorer> neededExplorers = explorers.stream().filter(explorer -> explorer.getEnergy() >= 0)
                .collect(Collectors.toList());
        Collection<String> exhibits = state.getExhibits();
        List<String> newList = new ArrayList<>(exhibits);
        for (Explorer explorer : neededExplorers) {
            for (String exhibit : exhibits) {
                explorer.search();
                if (!explorer.canSearch()){
                    break;
                }
                explorer.getSuitcase().getExhibits().add(exhibit);
                newList.remove(exhibit);
                exhibits = newList;
            }
        }
        setExplorers(neededExplorers);
    }

    @Override
    public void setExplorers(Collection<Explorer> explorers) {
        this.explorers = explorers;
    }

    @Override
    public Collection<Explorer> getExplorers() {
        return explorers;
    }
}

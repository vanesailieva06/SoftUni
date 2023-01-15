package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;


import java.util.Collection;

public interface Mission {
    void explore(State state, Collection<Explorer> explorers);
    void setExplorers(Collection<Explorer> explorers);
    Collection<Explorer> getExplorers();
}

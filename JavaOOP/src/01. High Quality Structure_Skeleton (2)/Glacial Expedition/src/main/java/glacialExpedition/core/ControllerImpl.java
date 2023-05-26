package glacialExpedition.core;

import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.List;
import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements glacialExpedition.core.Controller {

    private ExplorerRepository explorerRepository;
    private StateRepository stateRepository;
    private Mission mission;
    private int exploreCount;

    public ControllerImpl() {
        explorerRepository = new ExplorerRepository();
        stateRepository = new StateRepository();
        mission = new MissionImpl();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;

        if (type.equals("NaturalExplorer")){
            explorer = new NaturalExplorer(explorerName);
        }else if (type.equals("GlacierExplorer")){
            explorer = new GlacierExplorer(explorerName);
        } else if (type.equals("AnimalExplorer")) {
            explorer = new AnimalExplorer(explorerName);
        }else{
            throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }

        explorerRepository.add(explorer);
        return String.format(EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State currentState = new StateImpl(stateName);
        currentState.setExhibits(List.of(exhibits));
        stateRepository.add(currentState);
        return String.format(STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer currentExplorer = explorerRepository.byName(explorerName);
        if (currentExplorer == null){
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST, explorerName));
        }
        explorerRepository.remove(currentExplorer);
        return String.format(EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        State currentState = stateRepository.byName(stateName);
        List<Explorer> validExplorer = explorerRepository.getCollection().stream().filter(explorer -> explorer.getEnergy() > 50)
                .collect(Collectors.toList());
        if (validExplorer == null){
            return "You must have at least one explorer to explore the state.";
        }
        mission.explore(currentState, validExplorer);
        exploreCount++;
        int retiredExplorerCount = validExplorer.size() - mission.getExplorers().size();;
        return String.format(STATE_EXPLORER, stateName,retiredExplorerCount);
    }

    @Override
    public String finalResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_STATE_EXPLORED, exploreCount))
                .append(System.lineSeparator())
                .append(FINAL_EXPLORER_INFO)
                .append(System.lineSeparator());

        for (Explorer explorer : explorerRepository.getCollection()) {
            sb.append(String.format(FINAL_EXPLORER_NAME, explorer.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(FINAL_EXPLORER_ENERGY, explorer.getEnergy()))
                    .append(System.lineSeparator());
            if (explorer.getSuitcase().getExhibits().size() == 0){
                sb.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, "None"))
                        .append(System.lineSeparator());
            }else {
                sb.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER,
                        explorer.getSuitcase().getExhibits())))
                        .append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }


}

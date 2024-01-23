package com.resellerapp.service.impl;

import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.entity.ConditionNameEnum;
import com.resellerapp.repository.ConditionRepository;
import com.resellerapp.service.ConditionService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ConditionServiceImpl implements ConditionService {
    private final ConditionRepository conditionRepository;

    public ConditionServiceImpl(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    @Override
    public void initCondition() {
        if (conditionRepository.count() != 0){
            return;
        }
        Arrays.stream(ConditionNameEnum.values())
                .forEach(conditionNameEnum -> {
                    Condition condition = new Condition();
                    condition.setName(conditionNameEnum);
                    String changedDescription = "";
                    switch (conditionNameEnum){
                        case GOOD -> changedDescription = "In perfect condition";
                        case EXCELLENT -> changedDescription = "Some signs of wear and tear or minor defects";
                        case ACCEPTABLE -> changedDescription = "The item is fairly worn but continues to function properly";
                    }
                    condition.setDescription(changedDescription);

                    conditionRepository.save(condition);
                });
    }

    @Override
    public Condition findByEnumName(ConditionNameEnum condition) {
        return conditionRepository.findByName(condition).orElse(null);
    }
}

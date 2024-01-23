package com.example.demo.service.impl;

import com.example.demo.model.entity.Model;
import com.example.demo.repository.ModelRepository;
import com.example.demo.service.ModelService;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public Model findByName(String model) {
        return modelRepository.findByName(model).orElse(null);
    }
}

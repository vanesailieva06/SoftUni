package com.example.jsonProcessing.service.impl;

import com.example.jsonProcessing.model.dto.CategorySeedDto;
import com.example.jsonProcessing.model.entity.Category;
import com.example.jsonProcessing.repository.CategoryRepository;
import com.example.jsonProcessing.service.CategoryService;
import com.example.jsonProcessing.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.jsonProcessing.coinstraints.GlobalConstraints.*;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private static final String CATEGORY_FILE_NAME = "categories.json";

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }


    @Override
    public void seedCategories() throws IOException {
        if (categoryRepository.count() == 0){
            String content = Files.readString(Path.of(FILES_PATH + CATEGORY_FILE_NAME));

            CategorySeedDto[] categorySeedDtos = gson.fromJson(content, CategorySeedDto[].class);

            Arrays.stream(categorySeedDtos).filter(validationUtil::isValid)
                    .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                    .forEach(categoryRepository::save);
        }
    }

    @Override
    public Set<Category> getRandomCategories() {
        int randInt = ThreadLocalRandom.current().nextInt(1, 4);
        Set<Category> categorySet = new HashSet<>();
        for (int i = 0; i < randInt; i++) {
            Long randomId = ThreadLocalRandom.current().nextLong(1, categoryRepository.count() + 1);
            Category randCategory = categoryRepository.findById(randomId).orElse(null);
            categorySet.add(randCategory);
        }
        return categorySet;
    }
}

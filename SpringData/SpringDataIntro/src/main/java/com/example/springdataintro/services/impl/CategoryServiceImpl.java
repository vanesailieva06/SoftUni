package com.example.springdataintro.services.impl;

import com.example.springdataintro.entities.Category;
import com.example.springdataintro.repositories.CategoryRepository;
import com.example.springdataintro.services.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final String CATEGORY_FILE_PATH = "src/main/resources/files/categories.txt";
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategory() throws IOException {
        if (categoryRepository.count() > 0){
            return;
        }
        Files.readAllLines(Path.of(CATEGORY_FILE_PATH))
                .stream().filter(row -> !row.isEmpty())
                .forEach(catName -> {
                    Category category = new Category(catName);

                    categoryRepository.save(category);
                });
    }

    @Override
    public Set<Category> getRandomCategories() {
        Set<Category> categories = new HashSet<>();
        int randInt = ThreadLocalRandom.current().nextInt(1, 4);

        for (int i = 0; i < randInt; i++) {
            long randCatId = ThreadLocalRandom.current().nextLong(1, categoryRepository.count() + 1);
            Category category = categoryRepository.findById(randCatId).orElse(null);
            categories.add(category);
        }
        return categories;
    }
}

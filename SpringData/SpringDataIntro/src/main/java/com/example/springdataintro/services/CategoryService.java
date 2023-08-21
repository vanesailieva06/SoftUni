package com.example.springdataintro.services;

import com.example.springdataintro.entities.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategory() throws IOException;

    Set<Category> getRandomCategories();
}

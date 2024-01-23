package com.example.pathfinder.service;

import com.example.pathfinder.model.entity.Categories;
import com.example.pathfinder.model.entity.enums.CategoryEnum;

public interface CategoryService {
    Categories findByName(CategoryEnum categoryEnum);
}

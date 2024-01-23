package com.example.pathfinder.repository;

import com.example.pathfinder.model.entity.Categories;
import com.example.pathfinder.model.entity.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long> {

    Optional<Categories> findByName(CategoryEnum name);
}

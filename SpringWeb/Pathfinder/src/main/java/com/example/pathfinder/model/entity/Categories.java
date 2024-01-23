package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.CategoryEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Categories extends BaseEntity{
    private CategoryEnum name;
    private String description;

    public Categories() {
    }

    @Enumerated(EnumType.STRING)
    public CategoryEnum getName() {
        return name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
    }

    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}

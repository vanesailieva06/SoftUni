package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.NameEnum;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "categories")
public class Categories extends BaseEntity{
    private NameEnum name;
    private String description;

    public Categories() {
    }

    @Enumerated(EnumType.STRING)
    public NameEnum getName() {
        return name;
    }

    public void setName(NameEnum name) {
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

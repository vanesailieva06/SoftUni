package com.example.pathfinder.model.dto;

import com.example.pathfinder.model.entity.enums.CategoryEnum;
import com.example.pathfinder.model.entity.enums.LevelEnum;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class RouteAddDto {

    private String name;
    private String description;
    private MultipartFile gpxCoordinates;
    private LevelEnum level;
    private String videoUrl;
    private List<CategoryEnum> categories;

    public RouteAddDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(MultipartFile gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public List<CategoryEnum> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEnum> categories) {
        this.categories = categories;
    }
}

package com.example.demo.model.dto;

import com.example.demo.model.entity.Engine;
import com.example.demo.model.entity.Transmission;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OfferViewDto {
    private Integer offerYear;
    private String brandName;
    private Integer mileage;
    private String modelName;
    private Engine engine;
    private BigDecimal price;
    private Transmission transmission;
    private LocalDateTime created;
    private LocalDateTime modified;
    private String fullName;
    private String imageUrl;

    public OfferViewDto() {
    }

    public Integer getOfferYear() {
        return offerYear;
    }

    public void setOfferYear(Integer offerYear) {
        this.offerYear = offerYear;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }
}

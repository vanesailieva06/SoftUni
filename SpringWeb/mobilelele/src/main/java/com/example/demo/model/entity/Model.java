package com.example.demo.model.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "models")
public class Model extends BaseEntity{
//    · name – a model name.
//
//· category – an enumeration (Car, Buss, Truck, Motorcycle)
//
//· imageUrl – the url of image with size between 8 and 512 characters.
//
//· startYear – a number.
//
//· endYear – a number.
//
//· created – a date and time.
//
//· modified – a date and time.
//
//· brand – a model brand.

    private String name;
    private Category category;
    private String imageUrl;
    private int startYear;
    private int endYear;
    private LocalDateTime created;
    private LocalDateTime modified;
    private Brand brand;

    public Model() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "image_url", length = 512)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column(name = "start_year")
    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    @Column(name = "end_year")
    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    @Column(name = "created")
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Column(name = "modified")
    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    @ManyToOne
    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}

package com.example.shoppinglist.model.view;

import com.example.shoppinglist.model.entity.Category;

import java.math.BigDecimal;

public class ProductViewModel {
    private Long id;
    private String name;
    private BigDecimal price;
    private Category category;

    public ProductViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

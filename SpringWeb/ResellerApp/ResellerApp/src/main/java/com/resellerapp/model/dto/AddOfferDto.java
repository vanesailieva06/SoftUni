package com.resellerapp.model.dto;

import com.resellerapp.model.entity.ConditionNameEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class AddOfferDto {
    private String description;
    private BigDecimal price;
    private ConditionNameEnum condition;

    public AddOfferDto() {
    }

    @NotNull
    @Size(min = 3, max =  50, message = "Description length must be between 2 and 50 characters (inclusive of 2 and 50).")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull
    @Positive(message = "Price must be a positive number")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull(message = "You must select condition")
    public ConditionNameEnum getCondition() {
        return condition;
    }

    public void setCondition(ConditionNameEnum condition) {
        this.condition = condition;
    }
}

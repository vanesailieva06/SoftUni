package com.resellerapp.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "conditions")
public class Condition extends BaseEntity{
//    •	Has an Id – “UUID-String” or Long
//•	Has a Condition name (unique, not null)
//o	an option between (EXCELLENT, GOOD, ACCEPTABLE)
//•	Has a Description  (not null)
    private ConditionNameEnum name;
    private String description;

    public Condition() {
    }

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    public ConditionNameEnum getName() {
        return name;
    }

    public void setName(ConditionNameEnum name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

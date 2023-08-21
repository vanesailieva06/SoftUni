package com.example.football.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity{
//    •	id – accepts integer values, a primary identification field, an auto incremented field.
//•	name – accepts char sequences as values where their character length value higher than or equal to 3
// . The values are unique in the database.
//•	stadium name – accepts char sequences as values where their character length value higher than or equal to 3.
//•	fan base – accepts number values that are more than or equal to 1000.
//•	history – a long and detailed description of team's history with a character length value higher than or equal to 10.
//o	Note: The teams table has relation with the towns table.
    private String name;
    private String stadiumName;
    private Integer fanBase;
    private String history;
    private Town town;

    public Team() {
    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "stadium_name", nullable = false)
    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    @Column(name = "fan_base", nullable = false)
    public Integer getFanBase() {
        return fanBase;
    }

    public void setFanBase(Integer fanBase) {
        this.fanBase = fanBase;
    }

    public String getHistory() {
        return history;
    }

    @Column(name = "history", nullable = false, columnDefinition = "TEXT")
    public void setHistory(String history) {
        this.history = history;
    }

    @ManyToOne
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}

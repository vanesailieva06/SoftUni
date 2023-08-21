package softuni.exam.models.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "stars")
public class Star extends BaseEntity{
//    •	id – accepts integer values, a primary identification field, an auto incremented field.
//•	name - accepts char sequence (between 2 to 30 inclusive). The values are unique in the database.
//•	light years - The distance from Earth in light years. Accepts only positive number.
//•	description - a long and detailed description about the star with a character length value higher than or equal to 6.
//•	star type - categorization of the stars. Ordinal enumeration, one of the following – RED_GIANT, WHITE_DWARF, NEUTRON_STAR
//•	observers – a collection with all the astronomers that are studying the star.
//•	Constraint: The stars table has a relation with the constellations table.
//•	Constraint: The stars table has a relation with the astronomers table.
    private String name;
    private Double lightYears;
    private String description;
    private StarType starType;
    private Set<Astronomer> astronomers;
    private Constellation constellation;

    public Star() {
    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "light_years", nullable = false)
    public Double getLightYears() {
        return lightYears;
    }

    public void setLightYears(Double year) {
        this.lightYears = year;
    }

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "star_type", nullable = false)
    public StarType getStarType() {
        return starType;
    }

    public void setStarType(StarType starType) {
        this.starType = starType;
    }

    @OneToMany(mappedBy = "star")
    public Set<Astronomer> getAstronomers() {
        return astronomers;
    }

    public void setAstronomers(Set<Astronomer> astronomers) {
        this.astronomers = astronomers;
    }

    @ManyToOne
    public Constellation getConstellation() {
        return constellation;
    }

    public void setConstellation(Constellation constellation) {
        this.constellation = constellation;
    }
}

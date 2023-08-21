package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "constellations")
public class Constellation extends BaseEntity{
//•	id – accepts integer values, a primary identification field, an auto incremented field.
//•	name – accepts char sequence (between 3 to 20 inclusive). The values are unique in the database.
//•	description - accepts char sequence about the naming of the constellation with a character length value higher than or equal to 5.
//•	stars – a collection of all stars that are part the constellation
//•	Constraint: The constellations table has a relation with the stars table.
    private String name;
    private String description;
    private Set<Star> stars;

    public Constellation() {
    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "constellation")
    public Set<Star> getStars() {
        return stars;
    }

    public void setStars(Set<Star> stars) {
        this.stars = stars;
    }
}

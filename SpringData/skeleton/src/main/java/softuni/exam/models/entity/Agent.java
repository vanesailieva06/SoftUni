package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "agents")
public class Agent extends BaseEntity{
//    •	id – accepts integer values, a primary identification field, an auto incremented field.
//•	first name – accepts char sequences as values where their character length value higher than or equal to 2
// . The values are unique in the database.
//•	last name – accepts char sequences as values where their character length value higher than or equal to 2.
//•	email – an email – (must contains ‘@’ and ‘.’ – dot). The email of a seller is unique.
//•	Constraint: The agents table has а relation with the towns table.
    private String firstName;
    private String lastName;
    private String email;
    private Town town;

    public Agent() {
    }

    @Column(name = "first_name", nullable = false, unique = true)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email", nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToOne
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}

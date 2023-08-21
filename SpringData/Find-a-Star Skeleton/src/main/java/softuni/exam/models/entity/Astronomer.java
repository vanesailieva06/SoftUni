package softuni.exam.models.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "astronomers")
public class Astronomer extends BaseEntity{
//    •	id - accepts integer values, a primary identification field, an auto incremented field.
//•	first name - accepts char sequence (between 2 to 30 inclusive).
//•	last name - accepts char sequence (between 2 to 30 inclusive).
//•	salary - accepts number values that are more than or equal to 15000.00.
//•	averageObservationHours - accepts number values that are more than 500.00.
//•	birthday - a date in the "yyyy-MM-dd" format. Can be nullable.
//•	observing star - the current star that the astronomer is studying.
//•	Constraint: The astronomers table has a relation with stars table.
    private String firstName;
    private String lastName;
    private Double salary;
    private Double averageObservationHours;
    private LocalDate birthday;
    private Star star;

    public Astronomer() {
    }

    @Column(name = "first_name", nullable = false)
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

    @Column(name = "salary", nullable = false)
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Column(name = "average_observation_hours", nullable = false)
    public Double getAverageObservationHours() {
        return averageObservationHours;
    }

    public void setAverageObservationHours(Double averageObservationHours) {
        this.averageObservationHours = averageObservationHours;
    }

    @Column(name = "birthday")
    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @ManyToOne
    @JoinColumn(name = "observing_star_id")
    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }
}

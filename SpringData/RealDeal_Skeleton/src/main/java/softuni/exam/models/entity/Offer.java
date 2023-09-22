package softuni.exam.models.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{
    private String firstName;
    private String lastName;
    private String email;
    private Rating rating;
    private String town;
    private Car car;
    private Seller seller;

    public Offer() {
    }

    @Column(name = "first_name", length = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", length = 20)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email", unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "rating", nullable = false)
    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Column(name = "town", nullable = false)
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @ManyToOne
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToOne
    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}

package softuni.exam.models.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {
    private String make;
    private String model;
    private Integer kilometers;
    private LocalDateTime registeredOn;
    private Set<Picture> pictures;

    public Car() {
    }

    @Column(name = "make", length = 20)
    public String getMake() {
        return make;
    }


    public void setMake(String make) {
        this.make = make;
    }

    @Column(name = "model", length = 20)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "kilometers")
    public Integer getKilometers() {
        return kilometers;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }

    @Column(name = "registered_on")
    public LocalDateTime getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDateTime registeredOn) {
        this.registeredOn = registeredOn;
    }

    @OneToMany
    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }
}

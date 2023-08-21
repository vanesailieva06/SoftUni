package softuni.exam.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "apartments")
public class Apartment extends BaseEntity{
//    •	id – accepts integer values, a primary identification field, an auto incremented field.
//•	apartment type – the enumeration, one of the following – two_rooms, three_rooms, four_rooms
//•	area – accepts number values that are more than or equal to 40.00.
//•	Constraint: The apartment table has а relation with the towns table.
    private ApartmentType apartmentType;
    private Double area;
    private Town town;

    public Apartment() {
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "apartment_type", nullable = false)
    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    @Column(name = "area", nullable = false)
    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    @ManyToOne
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}

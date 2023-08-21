package softuni.exam.models.dto;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "astronomer")
@XmlAccessorType(XmlAccessType.FIELD)
public class AstronomerSeedDto {
    @XmlElement(name = "average_observation_hours")
    private Double averageObservationHours;
    @XmlElement(name = "birthday")
    private String birthday;
    @XmlElement(name = "first_name")
    private String firstName;
    @XmlElement(name = "last_name")
    private String lastName;
    @XmlElement(name = "salary")
    private Double salary;
    @XmlElement(name = "observing_star_id")
    private Long observationStarId;

    public AstronomerSeedDto() {
    }

    @DecimalMin(value = "500.00")
    public Double getAverageObservationHours() {
        return averageObservationHours;
    }


    public void setAverageObservationHours(Double averageObservationHours) {
        this.averageObservationHours = averageObservationHours;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Size(min = 2, max = 30)
    @NotNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Size(min = 2, max = 30)
    @NotNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @DecimalMin(value = "15000.00")
    @NotNull
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


    public Long getObservationStarId() {
        return observationStarId;
    }

    public void setObservationStarId(Long observationStarId) {
        this.observationStarId = observationStarId;
    }
}

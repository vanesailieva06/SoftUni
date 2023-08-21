package softuni.exam.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity{
    private String countryName;

    private String currency;

    public Country() {
    }

    @Column(name = "country_name", length = 60,unique = true, nullable = false)
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Column(name = "currency", length = 20, nullable = false)
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

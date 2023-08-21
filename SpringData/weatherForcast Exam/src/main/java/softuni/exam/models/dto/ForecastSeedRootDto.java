package softuni.exam.models.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "forecasts")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastSeedRootDto {
    @XmlElement(name = "forecast")
    private List<ForecastSeedDto> forecasts;

    public ForecastSeedRootDto() {
    }

    public List<ForecastSeedDto> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<ForecastSeedDto> forecasts) {
        this.forecasts = forecasts;
    }
}

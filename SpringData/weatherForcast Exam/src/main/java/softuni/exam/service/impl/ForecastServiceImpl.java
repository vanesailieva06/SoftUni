package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastSeedRootDto;
import softuni.exam.models.entity.DayOfWeek;
import softuni.exam.models.entity.Forecast;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.CityService;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ForecastServiceImpl implements ForecastService {
    private final ForecastRepository forecastRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final CityService cityService;
    private static final String FORECAST_FILE_PATH = "src/main/resources/files/xml/forecasts.xml";

    public ForecastServiceImpl(ForecastRepository forecastRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, CityService cityService) {
        this.forecastRepository = forecastRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.cityService = cityService;
    }

    @Override
    public boolean areImported() {
        return forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of(FORECAST_FILE_PATH));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();
        ForecastSeedRootDto forecastSeedRootDto = xmlParser.fromFile(FORECAST_FILE_PATH, ForecastSeedRootDto.class);

        forecastSeedRootDto.getForecasts().stream().filter(forecastSeedDto -> {
                    boolean isValid = validationUtil.isValid(forecastSeedDto)
                            && (forecastSeedDto.getDayOfWeek().equals("FRIDAY") ||
                            forecastSeedDto.getDayOfWeek().equals("SATURDAY") ||
                            forecastSeedDto.getDayOfWeek().equals("SUNDAY"))
                            && findByDayOfWeek(forecastSeedDto.getDayOfWeek(), forecastSeedDto.getCity()) == null;

            sb.append(isValid ? String.format("Successfully import forecast %s - %.2f", forecastSeedDto.getDayOfWeek(),
                    forecastSeedDto.getMaxTemperature()) :
                    "Invalid forecast")
                    .append(System.lineSeparator());
            return isValid;
        })
                .map(forecastSeedDto -> {
                    Forecast forecast = modelMapper.map(forecastSeedDto, Forecast.class);
                    forecast.setSunrise(LocalTime.parse(forecastSeedDto.getSunrise(), DateTimeFormatter.ofPattern("HH:mm:ss")));
                    forecast.setSunset(LocalTime.parse(forecastSeedDto.getSunset(), DateTimeFormatter.ofPattern("HH:mm:ss")));
                    forecast.setCity(cityService.findById(forecastSeedDto.getCity()));
                    return forecast;
                })
                .forEach(forecastRepository::save);
        return sb.toString();
    }

    private Forecast findByDayOfWeek(String dayOfWeek, Long city) {

        return forecastRepository.findByDayOfWeekAndAndCity_Id(DayOfWeek.valueOf(dayOfWeek), city);
    }


    @Override
    public String exportForecasts() {
        StringBuilder sb = new StringBuilder();
        List<Forecast> forecasts =
                forecastRepository.findForecastWithDayOfWeekAndCityPopulationLessThanOrderByMaxTemperatureDescAndId(DayOfWeek.valueOf("SUNDAY"), 150000);
        forecasts.forEach(forecast -> {
            sb.append(String.format("""
                            City: %s:
                               \t\t-min temperature: %.2f
                               \t\t--max temperature: %.2f
                               \t\t---sunrise: %s
                            ----sunset: %s
                            """, forecast.getCity().getCityName(),
                    forecast.getMinTemperature(),
                    forecast.getMaxTemperature(),
                    forecast.getSunrise(),
                    forecast.getSunset())).append(System.lineSeparator());
        });
        return sb.toString();
    }
}

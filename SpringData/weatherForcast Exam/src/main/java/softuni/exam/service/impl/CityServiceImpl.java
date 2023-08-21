package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CitySeedDto;
import softuni.exam.models.entity.City;
import softuni.exam.repository.CityRepository;
import softuni.exam.service.CityService;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final CountryService countryService;
    private static final String CITIES_FILE_PATH = "src/main/resources/files/json/cities.json";

    public CityServiceImpl(CityRepository cityRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson, CountryService countryService) {
        this.cityRepository = cityRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.countryService = countryService;
    }

    @Override
    public boolean areImported() {
        return cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(Path.of(CITIES_FILE_PATH));
    }

    @Override
    public String importCities() throws IOException {
        StringBuilder sb = new StringBuilder();
        CitySeedDto[] citySeedDtos = gson.fromJson(readCitiesFileContent(), CitySeedDto[].class);
        Arrays.stream(citySeedDtos).filter(citySeedDto -> {
            boolean isValid = validationUtil.isValid(citySeedDto) && findByName(citySeedDto.getCityName()) == null;
            sb.append(isValid ? String.format("Successfully imported city %s - %d",citySeedDto.getCityName(),
                    citySeedDto.getPopulation()) : "Invalid city")
                    .append(System.lineSeparator());
            return isValid;
        }).map(citySeedDto -> {
            City city = modelMapper.map(citySeedDto, City.class);
            city.setCountry(countryService.findById(citySeedDto.getCountry()));
            return city;
        }).forEach(cityRepository::save);
        return sb.toString();
    }

    @Override
    public City findById(Long city) {

       return cityRepository.findById(city).orElse(null);
    }

    private City findByName(String cityName) {
        return cityRepository.findByCityName(cityName);
    }
}

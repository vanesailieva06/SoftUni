package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountrySeedDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private static final String COUNTRY_FILE_PATH = "src/main/resources/files/json/countries.json";

    public CountryServiceImpl(CountryRepository countryRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(Path.of(COUNTRY_FILE_PATH));
    }

    @Override
    public String importCountries() throws IOException {
        StringBuilder sb = new StringBuilder();
        CountrySeedDto[] countrySeedDtos = gson.fromJson(readCountriesFromFile(), CountrySeedDto[].class);

        Arrays.stream(countrySeedDtos).filter(countrySeedDto -> {
            boolean isValid = validationUtil.isValid(countrySeedDto) && findByName(countrySeedDto.getCountryName()) == null;

//            sb.append(isValid ? String.format("Successfully imported country %s - %s",
//                    countrySeedDto.getCountryName(), countrySeedDto.getCurrency())
//                    : "Invalid country")
//                    .append(System.lineSeparator());

            if (isValid){
                sb.append(String.format("Successfully imported country %s - %s",
                   countrySeedDto.getCountryName(), countrySeedDto.getCurrency()))
                        .append(System.lineSeparator());
            }else{
                sb.append("Invalid country").append(System.lineSeparator());
            }

            return isValid;
        })
                .map(countrySeedDto -> modelMapper.map(countrySeedDto, Country.class))
                .forEach(countryRepository::save);
        return sb.toString();
    }

    private Country findByName(String countryName) {
        return countryRepository.findByCountryName(countryName);
    }

    @Override
    public Country findById(Long countryId) {
        return countryRepository.findById(countryId).orElse(null);
    }
}

package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ConstellationSeedDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class ConstellationServiceImpl implements ConstellationService {
    private final ConstellationRepository constellationRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private static final String CONSTELLATION_FILE_PATH = "src/main/resources/files/json/constellations.json";

    public ConstellationServiceImpl(ConstellationRepository constellationRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.constellationRepository = constellationRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }


    @Override
    public boolean areImported() {
        return constellationRepository.count() > 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return Files.readString(Path.of(CONSTELLATION_FILE_PATH));
    }

    @Override
    public String importConstellations() throws IOException {
        StringBuilder sb = new StringBuilder();
        ConstellationSeedDto[] constellationSeedDtos = gson.fromJson(readConstellationsFromFile(), ConstellationSeedDto[].class);
        Arrays.stream(constellationSeedDtos).filter(constellationSeedDto -> {
            boolean isValid = validationUtil.isValid(constellationSeedDto) && findByName(constellationSeedDto.getName()) == null;

            sb.append(isValid ? String.format("Successfully imported constellation %s - %s",
                    constellationSeedDto.getName(), constellationSeedDto.getDescription()) :
                    "Invalid constellation").append(System.lineSeparator());

            return isValid;
        }).map(constellationSeedDto -> modelMapper.map(constellationSeedDto, Constellation.class))
                .forEach(constellationRepository::save);
        return sb.toString();
    }

    @Override
    public Constellation findById(Long constellation) {
       return constellationRepository.findById(constellation).orElse(null);
    }

    private Constellation findByName(String name) {
        return constellationRepository.findByName(name);
    }
}

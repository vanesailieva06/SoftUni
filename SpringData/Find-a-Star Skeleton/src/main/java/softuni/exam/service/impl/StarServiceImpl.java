package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.StarSeedDto;
import softuni.exam.models.entity.Star;
import softuni.exam.models.entity.StarType;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class StarServiceImpl implements StarService {
    private final StarRepository starRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final ConstellationService constellationService;
    private static final String STAR_FILE_PATH = "src/main/resources/files/json/stars.json";

    public StarServiceImpl(StarRepository starRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson, ConstellationService constellationService) {
        this.starRepository = starRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.constellationService = constellationService;
    }

    @Override
    public boolean areImported() {
        return starRepository.count() > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(Path.of(STAR_FILE_PATH));
    }

    @Override
    public String importStars() throws IOException {
        StringBuilder sb = new StringBuilder();
        StarSeedDto[] starSeedDtos = gson.fromJson(readStarsFileContent(), StarSeedDto[].class);
        Arrays.stream(starSeedDtos).filter(starSeedDto -> {
            boolean isValid = validationUtil.isValid(starSeedDto) && findByName(starSeedDto.getName()) == null;

            sb.append(isValid ? String.format("Successfully imported star %s - %.2f light years", starSeedDto.getName(),
                    starSeedDto.getLightYears()) : "Invalid star")
                    .append(System.lineSeparator());

            return isValid;
        }).map(starSeedDto -> {
                    Star star = modelMapper.map(starSeedDto, Star.class);
                    star.setConstellation(constellationService.findById(starSeedDto.getConstellation()));
                    star.setStarType(StarType.valueOf(starSeedDto.getStarType()));
                    return star;
                })
                .forEach(starRepository::save);
        return sb.toString();
    }

    private Star findByName(String name) {
        return starRepository.findByName(name);
    }

    @Override
    public String exportStars() {
        StringBuilder sb = new StringBuilder();
        List<Star> stars = starRepository.findStarsByStarTypeAndAstronomersStarIdIsNull(StarType.valueOf("RED_GIANT"));

        stars.forEach(star -> {
            sb.append(String.format("Star: %s", star.getName()))
                    .append(System.lineSeparator())
                    .append(String.format("   *Distance: %.2f light years", star.getLightYears()))
                    .append(System.lineSeparator())
                    .append(String.format("   **Description: %s",star.getDescription()))
                    .append(System.lineSeparator())
                    .append(String.format("   ***Constellation: %s",star.getConstellation().getName()))
                    .append(System.lineSeparator());
        });

        return sb.toString();
    }

    @Override
    public Star findById(Long observationStarId) {

        return starRepository.findById(observationStarId).orElse(null);
    }
}

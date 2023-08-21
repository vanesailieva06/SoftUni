package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AstronomerSeedRootDto;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AstronomerServiceImpl implements AstronomerService {
    private final AstronomerRepository astronomerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final StarService starService;
    private static final String ASTRONOMER_FILE_PATH = "src/main/resources/files/xml/astronomers.xml";

    public AstronomerServiceImpl(AstronomerRepository astronomerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, StarService starService) {
        this.astronomerRepository = astronomerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.starService = starService;
    }


    @Override
    public boolean areImported() {
        return this.astronomerRepository.count() > 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        return Files.readString(Path.of(ASTRONOMER_FILE_PATH));
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {
        List<Long> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        AstronomerSeedRootDto astronomerSeedRootDto = xmlParser.fromFile(ASTRONOMER_FILE_PATH, AstronomerSeedRootDto.class);
        astronomerSeedRootDto.getAstronomers().stream().filter(astronomerSeedDto -> {
            boolean isValid = (validationUtil.isValid(astronomerSeedDto) &&
                    findByFullName(astronomerSeedDto.getFirstName(), astronomerSeedDto.getLastName()) == null)
                    || (validationUtil.isValid(astronomerSeedDto) && findByStarId(astronomerSeedDto.getObservationStarId()) != null &&
                    !list.contains(astronomerSeedDto.getObservationStarId()) && starService.findById(astronomerSeedDto.getObservationStarId()) != null);

                sb.append(isValid ? String.format("Successfully imported astronomer %s %s - %.2f",
                        astronomerSeedDto.getFirstName(),
                        astronomerSeedDto.getLastName(),
                        astronomerSeedDto.getAverageObservationHours()) :
                        "Invalid astronomer").append(System.lineSeparator());

            return isValid;
        }).map(astronomerSeedDto -> {
                    Astronomer astronomer = modelMapper.map(astronomerSeedDto, Astronomer.class);
                    list.add(astronomerSeedDto.getObservationStarId());
                    astronomer.setStar(starService.findById(astronomerSeedDto.getObservationStarId()));
                    return astronomer;
                })
                .forEach(astronomerRepository::save);

        return sb.toString();
    }

    private Astronomer findByStarId(Long observationStarId) {
        return astronomerRepository.findByStar_Id(observationStarId);
    }

    private Astronomer findByFullName(String firstName, String lastName) {
        return astronomerRepository.findByFirstNameAndLastName(firstName,lastName);
    }
}

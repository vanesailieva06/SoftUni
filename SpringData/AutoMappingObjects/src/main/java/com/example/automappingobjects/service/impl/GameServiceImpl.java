package com.example.automappingobjects.service.impl;

import com.example.automappingobjects.model.dto.AddGameDto;
import com.example.automappingobjects.model.entity.Game;
import com.example.automappingobjects.repository.GameRepository;
import com.example.automappingobjects.service.GameService;
import com.example.automappingobjects.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;

    public GameServiceImpl(GameRepository gameRepository, ModelMapper mapper, ValidationUtil validationUtil) {
        this.gameRepository = gameRepository;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void addGame(AddGameDto addGameDto) {
        Set<ConstraintViolation<AddGameDto>> violations = validationUtil.violations(addGameDto);
        if (!violations.isEmpty()){
            violations.stream().map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        }
        Game game = mapper.map(addGameDto, Game.class);

        game.setReleaseDate(LocalDate.parse(addGameDto.getReleaseDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        gameRepository.save(game);
    }
}

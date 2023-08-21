package com.example.jsonProcessing.service.impl;

import com.example.jsonProcessing.coinstraints.GlobalConstraints;
import com.example.jsonProcessing.model.dto.UserSeedDto;
import com.example.jsonProcessing.model.entity.User;
import com.example.jsonProcessing.repository.UserRepository;
import com.example.jsonProcessing.service.UserService;
import com.example.jsonProcessing.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.jsonProcessing.coinstraints.GlobalConstraints.FILES_PATH;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private static final String USER_FILE_NAME = "users.json";

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public void seedUsers() throws IOException {
        if (userRepository.count() == 0){
            Arrays.stream(gson.fromJson(Files.readString(Path.of(FILES_PATH + USER_FILE_NAME)), UserSeedDto[].class))
                    .filter(validationUtil::isValid)
                    .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                    .forEach(userRepository::save);
        }
    }

    @Override
    public User getRandomUser() {
        Long randomId = ThreadLocalRandom.current().nextLong(1, userRepository.count() + 1);
        return userRepository.findById(randomId).orElse(null);
    }
}

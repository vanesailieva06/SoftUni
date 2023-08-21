package com.example.automappingobjects.service.impl;

import com.example.automappingobjects.model.dto.UserLoginDto;
import com.example.automappingobjects.model.dto.UserRegisterDto;
import com.example.automappingobjects.model.entity.User;
import com.example.automappingobjects.repository.UserRepository;
import com.example.automappingobjects.service.UserService;
import com.example.automappingobjects.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;
    private User loggedInUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper mapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())){
            System.out.println("Wrong confirm password");
            return;
        }
        Set<ConstraintViolation<UserRegisterDto>> violations = validationUtil.violations(userRegisterDto);

        if (!violations.isEmpty()){
            violations.stream().map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        User user = mapper.map(userRegisterDto, User.class);

       userRepository.save(user);

        System.out.println(user.getFullName() + " was registered");
    }

    @Override
    public void loginUser(UserLoginDto userLoginDto) {
        Set<ConstraintViolation<UserLoginDto>> violations = validationUtil.violations(userLoginDto);

        if (!violations.isEmpty()){
            violations.stream().map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        }

        User user = userRepository.findAllByEmailAndPassword(userLoginDto.getEmail(),
                        userLoginDto.getPassword())
                .orElse(null);

        if (user == null){
            System.out.println("Incorrect username / password");
            return;
        }

        loggedInUser = user;
        System.out.println("Successfully logged in " + loggedInUser.getFullName());
    }

    @Override
    public void logout() {
        if (loggedInUser == null){
            System.out.println("Cannot log out. No user was logged in.");
        }else{
            loggedInUser = null;
        }
    }
}

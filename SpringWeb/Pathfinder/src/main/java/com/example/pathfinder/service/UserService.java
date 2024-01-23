package com.example.pathfinder.service;

import com.example.pathfinder.model.dto.UserLoginDto;
import com.example.pathfinder.model.dto.UserRegisterDto;
import com.example.pathfinder.model.entity.User;

public interface UserService {

    void userRegister(UserRegisterDto userServiceModel);

    UserLoginDto findByUsernameAndPassword(String username, String password);

    void logout();

    User findById(Long id);

    User findByUsername(String username);

    User findByID(Long id);

}

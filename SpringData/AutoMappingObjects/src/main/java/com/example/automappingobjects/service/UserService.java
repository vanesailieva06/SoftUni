package com.example.automappingobjects.service;

import com.example.automappingobjects.model.dto.UserLoginDto;
import com.example.automappingobjects.model.dto.UserRegisterDto;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logout();
}

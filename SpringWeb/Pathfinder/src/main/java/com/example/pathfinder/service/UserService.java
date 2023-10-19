package com.example.pathfinder.service;

import com.example.pathfinder.model.service.UserServiceModel;

public interface UserService {

    void userRegister(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void logout();

    UserServiceModel findById(Long id);

    UserServiceModel findByUsername(String username);
}

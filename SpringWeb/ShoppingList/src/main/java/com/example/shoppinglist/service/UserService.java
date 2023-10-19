package com.example.shoppinglist.service;

import com.example.shoppinglist.model.entity.User;

public interface UserService {
    User findByUsername(String username);

    void registerUser(User user);

    User findByUsernameAndPassword(String username, String password);

    void logout();

}

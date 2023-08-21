package com.example.jsonProcessing.service;

import com.example.jsonProcessing.model.entity.User;

import java.io.IOException;

public interface UserService {
    void seedUsers() throws IOException;
    User getRandomUser();
}

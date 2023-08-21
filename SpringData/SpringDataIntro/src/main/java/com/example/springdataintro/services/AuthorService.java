package com.example.springdataintro.services;

import com.example.springdataintro.entities.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthor() throws IOException;

    Author getRandomAuthor();

    List<String> findAllAuthorsFirstNameLastNameAndBookCountOrderByBookSizeDesc();
}

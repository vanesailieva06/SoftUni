package com.example.springdataintro.services;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface BookService {
    void seedBook() throws IOException;

    List<String> findAllBooksTitleAfterYear(int year);

    List<String> findAllAuthorsWithBookWithReleaseDateBeforeYear(int year);

    List<String> findAllBookWIthAuthorsFirstAndLastNameOrderByReleaseDateAndTitle(String firstName, String secondName);
}

package com.example.springdataintro.services.impl;

import com.example.springdataintro.entities.Author;
import com.example.springdataintro.repositories.AuthorRepository;
import com.example.springdataintro.services.AuthorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private static final String AUTHOR_FILE_PATH = "src/main/resources/files/authors.txt";
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthor() throws IOException {
        if (authorRepository.count() > 0){
            return;
        }
        Files.readAllLines(Path.of(AUTHOR_FILE_PATH))
                .forEach(row ->{
                    String[] fullName = row.split("\\s+");
                    Author author = new Author(fullName[0], fullName[1]);

                    authorRepository.save(author);
                });

    }

    @Override
    public Author getRandomAuthor() {
        long randId = ThreadLocalRandom.current().nextLong(1, authorRepository.count() + 1);
        return authorRepository.findById(randId).orElse(null);
    }

    @Override
    public List<String> findAllAuthorsFirstNameLastNameAndBookCountOrderByBookSizeDesc() {
        return authorRepository.findAllByBookSizeDESC()
                .stream().map(author -> String.format("%s %s %d", author.getFirstName(),
                        author.getLastName(), author.getBooks().size()))
                .collect(Collectors.toList());
    }

}

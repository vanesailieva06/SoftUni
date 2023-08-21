package com.example.springdataintro.services.impl;

import com.example.springdataintro.entities.*;
import com.example.springdataintro.repositories.BookRepository;
import com.example.springdataintro.services.AuthorService;
import com.example.springdataintro.services.BookService;
import com.example.springdataintro.services.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOK_FILE_PATH = "src/main/resources/files/books.txt";
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBook() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }
        Files.readAllLines(Path.of(BOOK_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");
                    Book book = createBook(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<String> findAllBooksTitleAfterYear(int year) {
        return bookRepository.findBooksByReleaseDateAfter(LocalDate.of(year, 12, 31))
                .stream().map(book ->
                        String.format("%s", book.getTitle())
                )
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllAuthorsWithBookWithReleaseDateBeforeYear(int year) {
        return bookRepository.findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream().map(book -> String.format("%s %s",
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBookWIthAuthorsFirstAndLastNameOrderByReleaseDateAndTitle(String firstName, String lastName) {
        return bookRepository.findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream().map(book -> String.format("%s %s %d",
                        book.getTitle(), book.getReleaseDate(), book.getCopies()))
                .collect(Collectors.toList());
    }


    private Book createBook(String[] info) {
        EditionType editionType = EditionType.values()[Integer.parseInt(info[0])];
        LocalDate releaseDate = LocalDate.parse(info[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(info[2]);
        BigDecimal price = new BigDecimal(info[3]);
        AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(info[4])];
        String title = Arrays.stream(info).skip(5)
                .collect(Collectors.joining(" "));
        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService.getRandomCategories();
        Book book = new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);
        return book;
    }
}

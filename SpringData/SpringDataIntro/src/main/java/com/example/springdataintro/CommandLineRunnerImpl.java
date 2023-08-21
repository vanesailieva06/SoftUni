package com.example.springdataintro;

import com.example.springdataintro.services.AuthorService;
import com.example.springdataintro.services.BookService;
import com.example.springdataintro.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
        //printBooksTitleAfterYear(2000);
        //printAuthorsWithBooksWithReleaseDateBeforeYear(1990);
        //printAuthorsFirstNameLastNameAndBookCountOrderByBookSizeDesc();
        //printBooksWithAuthorsFirstAndLastNameOrderByReleaseDateDescAndTitle("George", "Powell");
    }

    private void printBooksWithAuthorsFirstAndLastNameOrderByReleaseDateDescAndTitle(String firstName, String secondName) {
        bookService.findAllBookWIthAuthorsFirstAndLastNameOrderByReleaseDateAndTitle(firstName, secondName)
                .forEach(System.out::println);
    }

    private void printAuthorsFirstNameLastNameAndBookCountOrderByBookSizeDesc() {
        authorService.findAllAuthorsFirstNameLastNameAndBookCountOrderByBookSizeDesc()
                .forEach(System.out::println);
    }

    private void printAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
        bookService.findAllAuthorsWithBookWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printBooksTitleAfterYear(int year) {
        bookService.findAllBooksTitleAfterYear(year)
                .forEach(System.out::println);
    }


    private void seedData() throws IOException {
        categoryService.seedCategory();
        authorService.seedAuthor();
        bookService.seedBook();
    }
}

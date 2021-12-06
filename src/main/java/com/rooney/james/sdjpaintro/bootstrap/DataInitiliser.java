package com.rooney.james.sdjpaintro.bootstrap;

import com.rooney.james.sdjpaintro.domain.Book;
import com.rooney.james.sdjpaintro.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Slf4j
@Profile({"local", "default"})
public class DataInitiliser implements CommandLineRunner {
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();

        Book book1 = Book.builder()
                .title("A Tale of Two Cities")
                .isbn("1234")
                .publisher("Publisher A")
                .build();

        Book book2 = Book.builder()
                .title("A Tale of Three Cities")
                .isbn("2341")
                .publisher("Publisher A")
                .build();


        Book book3 = Book.builder()
                .title("A Tale of Four Cities")
                .isbn("3412")
                .publisher("Publisher A")
                .build();


        log.info("Saving 3 books.");
        bookRepository.saveAll(Arrays.asList(book1, book2, book3));
    }
}

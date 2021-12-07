package com.rooney.james.sdjpaintro;

import com.rooney.james.sdjpaintro.domain.Book;
import com.rooney.james.sdjpaintro.domain.BookNatural;
import com.rooney.james.sdjpaintro.repository.BookNaturalRepository;
import com.rooney.james.sdjpaintro.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MySQLIntegrationTest {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookNaturalRepository bookNaturalRepository;

    @Test
    void testBookNatural() {
        BookNatural book = BookNatural.builder()
                .title("My Book")
                .isbn("8876")
                .publisher("Rooney")
                .build();

        BookNatural savedBook = bookNaturalRepository.save(book);

        BookNatural fetchedBook = bookNaturalRepository.getById(savedBook.getTitle());

        assertThat(fetchedBook).isNotNull();
    }

    @Test
    void testMySQL() {
        long countBefore = bookRepository.count();

        log.info("Number of saved books before test {}", countBefore);

        Book dickens = Book.builder()
                .publisher("PublisherGGG")
                .isbn("2399")
                .title("The House of Rooney")
                .build();

        bookRepository.save(dickens);

        long countAfter = bookRepository.count();

        log.info("Number of saved books after test {}", countAfter);

        assertThat(countBefore).isLessThan(countAfter);
    }
}

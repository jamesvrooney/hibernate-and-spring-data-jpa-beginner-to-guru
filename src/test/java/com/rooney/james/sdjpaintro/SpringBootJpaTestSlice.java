package com.rooney.james.sdjpaintro;

import com.rooney.james.sdjpaintro.domain.Book;
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
public class SpringBootJpaTestSlice {
    
    @Autowired
    BookRepository bookRepository;

    @Test
    void testJpaTestSlice() {
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

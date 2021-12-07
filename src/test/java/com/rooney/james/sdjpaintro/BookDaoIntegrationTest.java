package com.rooney.james.sdjpaintro;

import com.rooney.james.sdjpaintro.domain.Book;
import com.rooney.james.sdjpaintro.domain.dao.BookDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ActiveProfiles("local")
@ComponentScan(basePackages = {"com.rooney.james.sdjpaintro.domain.dao"})
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookDaoIntegrationTest {

    @Autowired
    BookDAO bookDAO;

    @Test
    void testUpdateBook() {
        Book unsavedBook = Book.builder()
                .title("My Book")
                .isbn("3456")
                .publisher("Rooney")
                .authorId(67L)
                .build();

        Book savedBook = bookDAO.saveNewBook(unsavedBook);

        savedBook.setTitle("NoHope");

        Book updatedBook = bookDAO.updateBook(savedBook);

        assertThat(updatedBook.getTitle()).isEqualTo("NoHope");
    }

    @Test
    void testDeleteBook() {
        Book unsavedBook = Book.builder()
                .title("My Book")
                .isbn("3456")
                .publisher("Rooney")
                .authorId(67L)
                .build();

        Book savedBook = bookDAO.saveNewBook(unsavedBook);

        bookDAO.deleteBook(savedBook.getId());

        Book deletedBook = bookDAO.getById(savedBook.getId());
        
        assertThat(deletedBook).isNull();
    }

    @Test
    void testSaveNewBook() {
        Book unsavedBook = Book.builder()
                .title("My Book")
                .isbn("3456")
                .publisher("Rooney")
                .authorId(67L)
                .build();

        Book savedBook = bookDAO.saveNewBook(unsavedBook);

        assertThat(savedBook.getId()).isNotNull();
    }

    @Test
    void testBookDao() {
        Book fetchedBook = bookDAO.getById(1L);

        assertThat(fetchedBook).isNotNull();
    }

    @Test
    void testGetBookByName() {
        Book fetchedBook = bookDAO.getByTitle("Domain-Driven Design");

        assertThat(fetchedBook).isNotNull();
    }
}

package com.rooney.james.sdjpaintro;

import com.rooney.james.sdjpaintro.domain.Author;
import com.rooney.james.sdjpaintro.domain.Book;
import com.rooney.james.sdjpaintro.domain.BookNatural;
import com.rooney.james.sdjpaintro.domain.composite.AuthorComposite;
import com.rooney.james.sdjpaintro.domain.composite.AuthorEmbedded;
import com.rooney.james.sdjpaintro.domain.composite.NameId;
import com.rooney.james.sdjpaintro.domain.dao.AuthorDAO;
import com.rooney.james.sdjpaintro.repository.*;
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
public class AuthorDaoIntegrationTest {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    AuthorDAO authorDAO;

    @Test
    void testAuthorDao() {
        Author author = Author.builder()
                .firstName("James")
                .lastName("Rooney")
                .build();

        Author savedAuthor = authorRepository.save(author);

        Author fetchedAuthor = authorDAO.getById(savedAuthor.getId());

        assertThat(fetchedAuthor).isNotNull();
    }
}

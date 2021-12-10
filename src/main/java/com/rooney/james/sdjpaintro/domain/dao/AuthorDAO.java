package com.rooney.james.sdjpaintro.domain.dao;

import com.rooney.james.sdjpaintro.domain.Author;

public interface AuthorDAO {
    Author getById(Long id);

    Author findAuthorByName(String firstName, String lastName);

    Author saveNewAuthor(Author author);

    Author updateAuthor(Author author);

    void deleteAuthorById(Long id);
}

package com.rooney.james.sdjpaintro.domain.dao;

import com.rooney.james.sdjpaintro.domain.Author;

public interface AuthorDAO {
    Author getById(Long id);

    Author getByName(String firstName, String lastName);

    Author saveNewAuthor(Author newAuthor);

    Author updateAuthor(Author savedAuthor);
}

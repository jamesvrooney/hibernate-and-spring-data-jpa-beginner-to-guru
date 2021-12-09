package com.rooney.james.sdjpaintro.domain.dao;

import com.rooney.james.sdjpaintro.domain.Author;

import java.util.List;

public interface AuthorDAO {
    List<Author> getAuthorsByLastNameLike(String lastName);

    Author getById(Long id);

    Author getByName(String firstName, String lastName);

    Author saveNewAuthor(Author newAuthor);

    Author updateAuthor(Author savedAuthor);

    void deleteAuthor(Long id);
}

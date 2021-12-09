package com.rooney.james.sdjpaintro.domain.dao.impl;

import com.rooney.james.sdjpaintro.domain.Author;
import com.rooney.james.sdjpaintro.domain.dao.AuthorDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@RequiredArgsConstructor
@Component
public class AuthorDaoImpl implements AuthorDAO {

    private final EntityManagerFactory emf;

    @Override
    public Author getById(Long id) {
        Author author = getEntityManager().find(Author.class, id);

        return author;
    }

    @Override
    public Author getByName(String firstName, String lastName) {
        return null;
    }

    @Override
    public Author saveNewAuthor(Author newAuthor) {
        return null;
    }

    @Override
    public Author updateAuthor(Author savedAuthor) {
        return null;
    }

    @Override
    public void deleteAuthor(Long id) {

    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}

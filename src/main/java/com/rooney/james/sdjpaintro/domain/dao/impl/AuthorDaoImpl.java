package com.rooney.james.sdjpaintro.domain.dao.impl;

import com.rooney.james.sdjpaintro.domain.Author;
import com.rooney.james.sdjpaintro.domain.dao.AuthorDAO;
import com.rooney.james.sdjpaintro.domain.dao.impl.mapper.AuthorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@RequiredArgsConstructor
@Component
public class AuthorDaoImpl implements AuthorDAO {

    @Override
    public Author getById(Long id) {
        return null;
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

    private RowMapper<Author> getRowMapper() {
        return new AuthorMapper();
    }
}

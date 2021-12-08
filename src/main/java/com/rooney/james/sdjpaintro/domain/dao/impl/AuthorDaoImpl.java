package com.rooney.james.sdjpaintro.domain.dao.impl;

import com.rooney.james.sdjpaintro.domain.Author;
import com.rooney.james.sdjpaintro.domain.dao.AuthorDAO;
import com.rooney.james.sdjpaintro.domain.dao.impl.mapper.AuthorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthorDaoImpl implements AuthorDAO {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Author getById(Long id) {
        Author author = jdbcTemplate.queryForObject("SELECT * FROM author WHERE id = ?", getRowMapper(), id);

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

    private RowMapper<Author> getRowMapper() {
        return new AuthorMapper();
    }
}

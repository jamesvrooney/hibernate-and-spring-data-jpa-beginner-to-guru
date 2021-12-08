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
        Author author = jdbcTemplate.queryForObject("SELECT * FROM author WHERE first_name = ? and last_name = ?", getRowMapper(), firstName, lastName);

        return author;
    }

    @Override
    public Author saveNewAuthor(Author newAuthor) {
        jdbcTemplate.update("INSERT INTO author (first_name, last_name) VALUES (?, ?)",
                newAuthor.getFirstName(),
                newAuthor.getLastName());

        Long createdId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);

        Author latestSavedAuthor = getById(createdId);

        return latestSavedAuthor;
    }

    @Override
    public Author updateAuthor(Author savedAuthor) {
        jdbcTemplate.update("UPDATE author SET first_name = ?, last_name = ? WHERE id = ?",
                savedAuthor.getFirstName(),
                savedAuthor.getLastName(),
                savedAuthor.getId());

        Author updatedAuthor = getById(savedAuthor.getId());

        return updatedAuthor;
    }

    @Override
    public void deleteAuthor(Long id) {
        jdbcTemplate.update("DELETE FROM author WHERE id = ?", id);
    }

    private RowMapper<Author> getRowMapper() {
        return new AuthorMapper();
    }
}

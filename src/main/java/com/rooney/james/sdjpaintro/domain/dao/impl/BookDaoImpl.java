package com.rooney.james.sdjpaintro.domain.dao.impl;

import com.rooney.james.sdjpaintro.domain.Author;
import com.rooney.james.sdjpaintro.domain.Book;
import com.rooney.james.sdjpaintro.domain.dao.AuthorDAO;
import com.rooney.james.sdjpaintro.domain.dao.BookDAO;
import com.rooney.james.sdjpaintro.domain.dao.BookDAO;
import com.rooney.james.sdjpaintro.domain.dao.impl.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@RequiredArgsConstructor
@Component
public class BookDaoImpl implements BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Book getById(Long id) {
        Book book = jdbcTemplate.queryForObject("SELECT * FROM book WHERE id = ?", getRowMapper(), id);

        return book;
    }

    @Override
    public Book getByTitle(String title) {
        Book book = jdbcTemplate.queryForObject("SELECT * FROM book WHERE title = ?", getRowMapper(), title);

        return book;
    }

    @Override
    public Book saveNewBook(Book newBook) {
        jdbcTemplate.update("INSERT INTO book (title, isbn, publisher, author_id) VALUES (?, ?, ?, ?)",
                newBook.getTitle(),
                newBook.getIsbn(),
                newBook.getPublisher(),
                newBook.getAuthorId());

        Long createdId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);

        Book latestSavedBook = getById(createdId);

        return latestSavedBook;
    }

    @Override
    public Book updateBook(Book savedBook) {
        jdbcTemplate.update("UPDATE book SET title = ?, isbn = ?, publisher = ?, author_id = ?",
                savedBook.getTitle(),
                savedBook.getIsbn(),
                savedBook.getPublisher(),
                savedBook.getAuthorId());

        Book updatedBook = getById(savedBook.getId());

        return updatedBook;
    }

    @Override
    public void deleteBook(Long id) {
        jdbcTemplate.update("DELETE FROM book WHERE id = ?", id);
    }

    private RowMapper<Book> getRowMapper() {
        return new BookMapper();
    }
}

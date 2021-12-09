package com.rooney.james.sdjpaintro.domain.dao.impl.mapper;

import com.rooney.james.sdjpaintro.domain.Author;
import com.rooney.james.sdjpaintro.domain.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuthorMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        rs.next();

        Author author = Author.builder()
                .id(rs.getLong("id"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .build();

        if (rs.getString("isbn") != null) {
            author.setBooks(new ArrayList<>());

            author.getBooks().add(mapBook(rs));
        }

        while (rs.next()) {
            author.getBooks().add(mapBook(rs));
        }

        return author;
    }

    private Book mapBook(ResultSet rs) throws SQLException {
        Book book = Book.builder()
                .id(rs.getLong("book_id"))
                .title(rs.getString("title"))
                .publisher(rs.getString("publisher"))
                .isbn(rs.getString("isbn"))
                .authorId(rs.getLong("id"))
                .build();

        return book;
    }
}

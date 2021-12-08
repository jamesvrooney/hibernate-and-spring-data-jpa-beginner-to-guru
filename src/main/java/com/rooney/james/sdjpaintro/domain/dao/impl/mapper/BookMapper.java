package com.rooney.james.sdjpaintro.domain.dao.impl.mapper;

import com.rooney.james.sdjpaintro.domain.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = Book.builder()
                .id(rs.getLong("id"))
                .title(rs.getString("title"))
                .publisher(rs.getString("publisher"))
                .isbn(rs.getString("isbn"))
                .authorId(rs.getLong("author_id"))
                .build();

        return book;
    }
}

package com.rooney.james.sdjpaintro.domain.dao.impl.mapper;

import com.rooney.james.sdjpaintro.domain.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = Author.builder()
                .id(rs.getLong("id"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .build();

        return author;
    }
}

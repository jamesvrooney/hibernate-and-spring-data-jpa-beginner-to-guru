package com.rooney.james.sdjpaintro.domain.dao.impl.mapper;

import com.rooney.james.sdjpaintro.domain.Author;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorExtractor implements ResultSetExtractor<Author> {
    @Override
    public Author extractData(ResultSet rs) throws SQLException, DataAccessException {
        return new AuthorMapper().mapRow(rs, 0);
    }
}

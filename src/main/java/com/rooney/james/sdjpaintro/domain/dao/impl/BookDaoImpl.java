package com.rooney.james.sdjpaintro.domain.dao.impl;

import com.rooney.james.sdjpaintro.domain.Book;
import com.rooney.james.sdjpaintro.domain.dao.AuthorDAO;
import com.rooney.james.sdjpaintro.domain.dao.BookDAO;
import com.rooney.james.sdjpaintro.domain.dao.BookDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@RequiredArgsConstructor
@Component
public class BookDaoImpl implements BookDAO {

    private final DataSource dataSource;

    @Override
    public Book getById(Long id) {
        return null;
    }

    @Override
    public Book getByTitle(String title) {
        return null;
    }

    @Override
    public Book saveNewBook(Book newBook) {
        return null;
    }

    @Override
    public Book updateBook(Book savedBook) {
        return null;
    }

    @Override
    public void deleteBook(Long id) {

    }
}

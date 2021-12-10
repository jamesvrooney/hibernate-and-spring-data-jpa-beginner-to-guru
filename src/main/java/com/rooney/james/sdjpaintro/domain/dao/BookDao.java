package com.rooney.james.sdjpaintro.domain.dao;

import com.rooney.james.sdjpaintro.domain.Book;

import java.util.stream.Stream;

public interface BookDao {
    Book getById(Long id);

    Book findBookByTitle(String title);

    Book saveNewBook(Book book);

    Book updateBook(Book book);

    void deleteBookById(Long id);
}
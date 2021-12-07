package com.rooney.james.sdjpaintro.domain.dao;

import com.rooney.james.sdjpaintro.domain.Book;

public interface BookDAO {
    Book getById(Long id);

    Book getByTitle(String title);

    Book saveNewBook(Book newBook);

    Book updateBook(Book savedBook);

    void deleteBook(Long id);
}

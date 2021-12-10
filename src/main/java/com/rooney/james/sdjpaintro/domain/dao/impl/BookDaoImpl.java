package com.rooney.james.sdjpaintro.domain.dao.impl;

import com.rooney.james.sdjpaintro.domain.Author;
import com.rooney.james.sdjpaintro.domain.Book;
import com.rooney.james.sdjpaintro.domain.dao.BookDao;
import com.rooney.james.sdjpaintro.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@Component
public class BookDaoImpl implements BookDao {

    private final BookRepository bookRepository;

    @Override
    public Book getById(Long id) {
        Book book = bookRepository.getById(id);

        return book;
    }

    @Override
    public Book findBookByTitle(String title) {
        return bookRepository.findByTitle(title).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Book saveNewBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    @Override
    public Book updateBook(Book book) {
        Book foundBook = bookRepository.getById(book.getId());

        foundBook.setTitle(book.getTitle());
        foundBook.setPublisher(book.getPublisher());
        foundBook.setIsbn(book.getIsbn());
        foundBook.setAuthorId(book.getAuthorId());

        return bookRepository.save(foundBook);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
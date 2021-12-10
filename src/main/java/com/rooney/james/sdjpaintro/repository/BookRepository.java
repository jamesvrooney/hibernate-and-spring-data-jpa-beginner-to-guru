package com.rooney.james.sdjpaintro.repository;

import com.rooney.james.sdjpaintro.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.Optional;
import java.util.stream.Stream;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String title);

    Book readByTitle(String foobar);

    @Nullable
    Book getByTitle(@Nullable String bar);

    Stream<Book> findAllByTitleNotNull();
}

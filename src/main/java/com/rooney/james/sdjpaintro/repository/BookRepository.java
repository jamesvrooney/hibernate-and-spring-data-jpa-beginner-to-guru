package com.rooney.james.sdjpaintro.repository;

import com.rooney.james.sdjpaintro.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.Async;

import java.util.Optional;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String title);

    Book readByTitle(String foobar);

    @Nullable
    Book getByTitle(@Nullable String bar);

    Stream<Book> findAllByTitleNotNull();

    @Async
    Future<Book> queryByTitle(String title);

    @Query("SELECT b FROM Book b WHERE b.title = ?1")
    Book findBookByTitleWithQuery(String title);
}

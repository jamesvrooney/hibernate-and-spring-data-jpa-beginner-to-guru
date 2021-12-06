package com.rooney.james.sdjpaintro.repository;

import com.rooney.james.sdjpaintro.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

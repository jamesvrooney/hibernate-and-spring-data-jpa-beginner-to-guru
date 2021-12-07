package com.rooney.james.sdjpaintro.repository;

import com.rooney.james.sdjpaintro.domain.Book;
import com.rooney.james.sdjpaintro.domain.BookNatural;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookNaturalRepository extends JpaRepository<BookNatural, String> {
}

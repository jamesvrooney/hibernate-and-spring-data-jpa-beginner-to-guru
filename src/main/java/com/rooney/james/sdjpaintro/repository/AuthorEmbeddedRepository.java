package com.rooney.james.sdjpaintro.repository;

import com.rooney.james.sdjpaintro.domain.composite.AuthorComposite;
import com.rooney.james.sdjpaintro.domain.composite.AuthorEmbedded;
import com.rooney.james.sdjpaintro.domain.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorEmbeddedRepository extends JpaRepository<AuthorEmbedded, NameId> {
}

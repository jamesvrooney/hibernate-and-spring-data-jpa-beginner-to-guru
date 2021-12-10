package com.rooney.james.sdjpaintro.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NamedQuery(name = "author_find_all", query = "From Author")
@NamedQuery(name = "author_find_by_name", query = "From Author a WHERE a.firstName = :firstName AND a.lastName = :lastName")
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @Transient
    private List<Book> books;
}

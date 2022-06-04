package dev.struchkov.library.domain.entity;

import dev.struchkov.library.domain.BookStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Setter
@Getter
@Table("book")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Book extends BasicEntity {

    @Column("title")
    private String title;

    @Column("description")
    private String description;

    @Column("isbn")
    private String isbn;

    @Column("status")
    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;

    @Column("publication_date")
    private LocalDate publicationDate;

    @Column("author")
    private Long authorId;

}

package dev.struchkov.library.domain.entity;

import dev.struchkov.library.domain.BookStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "book")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Book extends BasicEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @Column(name = "author", insertable = false, updatable = false)
    private Long authorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author")
    private Author author;

    @ManyToMany
    @JoinTable(
            name = "publishing_book",
            inverseJoinColumns = @JoinColumn(name = "publishing_house_id"),
            joinColumns = @JoinColumn(name = "book_id")
    )
    private List<PubHouse> pubHouse;

}

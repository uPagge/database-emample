package dev.struchkov.library.web.dto;

import dev.struchkov.library.domain.BookStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookDto {

    private String title;

    private String description;

    private String isbn;

    private BookStatus bookStatus;

    private LocalDate publicationDate;

    private AuthorDto author;

    private Long authorId;

}

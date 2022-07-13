package dev.struchkov.library.web.dto;

import dev.struchkov.library.domain.BookStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Schema(description = "Книга")
public class BookDto {

    private Long id;

    private String title;

    private String description;

    private String isbn;

    private BookStatus bookStatus;

    private LocalDate publicationDate;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private AuthorDto author;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long authorId;

}

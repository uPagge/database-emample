package dev.struchkov.library.domain.filter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookFilter {

    private String title;
    private LocalDate publicationDateFrom;
    private LocalDate publicationDateTo;

}

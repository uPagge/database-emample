package dev.struchkov.library.web.controller;

import dev.struchkov.library.context.service.BookService;
import dev.struchkov.library.domain.entity.Book;
import dev.struchkov.library.domain.filter.BookFilter;
import dev.struchkov.library.web.dto.BookDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/book")
@RequiredArgsConstructor
@Tag(name = "Контроллер книг")
public class BookController {

    private final BookService bookService;
    private final ConversionService conversionService;

    @GetMapping(value = "{id}", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Получить книгу по идентификатору")
    public ResponseEntity<BookDto> getById(@PathVariable Long id) {
        final Book book = bookService.getByIdOrThrown(id);
        return ResponseEntity.ok(
                conversionService.convert(
                        book, BookDto.class
                )
        );
    }

    @GetMapping(value = "search/publish-date", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Поиск по дате публикации книги")
    public ResponseEntity<BookDto> searchByPublicationDate(
            @RequestParam(value = "from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam(value = "to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
    ) {
        return ResponseEntity.ok(
                conversionService.convert(
                        bookService.getByPublicationDateBetween(from, to),
                        BookDto.class
                )
        );
    }

    @GetMapping(value = "search/nickname-author", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Поиск по псевдониму автора")
    public ResponseEntity<BookDto> searchByAuthorNickname(
            @RequestParam(value = "nickname") String nickName
    ) {
        return ResponseEntity.ok(
                conversionService.convert(
                        bookService.getByAuthorNickname(nickName),
                        BookDto.class
                )
        );
    }

    @GetMapping(value = "search/lastname-author", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Поиск по фамилии автора")
    public ResponseEntity<BookDto> searchByLastName(
            @RequestParam(value = "lastName") String lastName
    ) {
        return ResponseEntity.ok(
                conversionService.convert(
                        bookService.getByAuthorLastName(lastName),
                        BookDto.class
                )
        );
    }

    @PutMapping(value = "update", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @Operation(summary = "Обновление книги")
    public ResponseEntity<BookDto> update(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(
                conversionService.convert(
                        bookService.update(
                                conversionService.convert(bookDto, Book.class)
                        ),
                        BookDto.class
                )
        );
    }

    @PostMapping(value = "filter", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @Operation(summary = "Фильтр")
    public ResponseEntity<BookDto> filter(@RequestBody BookFilter filter) {
        return ResponseEntity.ok(
                conversionService.convert(
                        bookService.filter(filter),
                        BookDto.class
                )
        );
    }

}

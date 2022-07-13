package dev.struchkov.library.context.service;

import dev.struchkov.library.domain.entity.Book;
import dev.struchkov.library.domain.filter.BookFilter;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;

public interface BookService extends BasicService<Book, Long> {

    List<Book> getByPublicationDateBetween(@NonNull LocalDate from, @NonNull LocalDate to);

    List<Book> getByAuthorNickname(@NonNull String authorNickName);

    List<Book> filter(@NonNull BookFilter filter);

    List<Book> getByAuthorLastName(@NonNull String lastName);

}

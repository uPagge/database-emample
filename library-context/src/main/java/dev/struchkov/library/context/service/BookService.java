package dev.struchkov.library.context.service;

import dev.struchkov.library.domain.entity.Book;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;

public interface BookService extends BasicService<Book, Long> {

    List<Book> getByPublicationDateBetween(@NonNull LocalDate from, @NonNull LocalDate to);

    List<Book> findByAuthorNickname(@NonNull String authorNickName);

}

package dev.struchkov.library.context.repository;

import dev.struchkov.library.domain.entity.Book;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookRepository {

    Optional<Book> findById(@NonNull Long bookId);

    List<Book> findByPublicationDateBetween(@NonNull LocalDate from, @NonNull LocalDate to);

    List<Book> findByAuthorNickname(@NonNull String authorNickName);

}

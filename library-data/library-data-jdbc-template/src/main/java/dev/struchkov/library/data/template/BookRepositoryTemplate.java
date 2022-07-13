package dev.struchkov.library.data.template;

import dev.struchkov.library.context.repository.BookRepository;
import dev.struchkov.library.data.template.crud.BookCrudRepository;
import dev.struchkov.library.domain.entity.Book;
import dev.struchkov.library.domain.filter.BookFilter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookRepositoryTemplate implements BookRepository {

    private final BookCrudRepository crudRepository;

    @Override
    public Optional<Book> findById(@NonNull Long bookId) {
        return crudRepository.findById(bookId);
    }

    @Override
    public List<Book> findByPublicationDateBetween(@NonNull LocalDate from, @NonNull LocalDate to) {
        return crudRepository.findAllByPublicationDateBetween(from, to);
    }

    @Override
    public List<Book> findByAuthorNickname(@NonNull String authorNickName) {
        return crudRepository.findByAuthorNickname(authorNickName);
    }

    @Override
    public List<Book> filter(@NonNull BookFilter filter) {
        return null;
    }

    @Override
    public List<Book> findByAuthorLastName(@NonNull String lastName) {
        return null;
    }

}

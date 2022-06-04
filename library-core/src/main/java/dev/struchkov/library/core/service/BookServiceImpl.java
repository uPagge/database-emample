package dev.struchkov.library.core.service;

import dev.struchkov.library.context.repository.BookRepository;
import dev.struchkov.library.context.service.BookService;
import dev.struchkov.library.domain.entity.Book;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static dev.struchkov.library.context.exception.NotFoundException.notFoundException;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getByPublicationDateBetween(@NonNull LocalDate from, @NonNull LocalDate to) {
        return bookRepository.findByPublicationDateBetween(from, to);
    }

    @Override
    public List<Book> findByAuthorNickname(@NonNull String authorNickName) {
        return bookRepository.findByAuthorNickname(authorNickName);
    }

    @Override
    public Optional<Book> getById(@NonNull Long bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public Book getByIdOrThrown(@NonNull Long bookId) {
        return getById(bookId).orElseThrow(notFoundException("Книга не найдена {0}", bookId));
    }

}

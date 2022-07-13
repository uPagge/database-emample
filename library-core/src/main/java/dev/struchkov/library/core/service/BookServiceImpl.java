package dev.struchkov.library.core.service;

import dev.struchkov.library.context.repository.BookRepository;
import dev.struchkov.library.context.service.BookService;
import dev.struchkov.library.domain.entity.Book;
import dev.struchkov.library.domain.filter.BookFilter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Book> getByAuthorNickname(@NonNull String authorNickName) {
        return bookRepository.findByAuthorNickname(authorNickName);
    }

    @Override
    public List<Book> filter(@NonNull BookFilter filter) {
        return bookRepository.filter(filter);
    }

    @Override
    public List<Book> getByAuthorLastName(@NonNull String lastName) {
        return bookRepository.findByAuthorLastName(lastName);
    }

    @Override
    @Transactional
    public Optional<Book> getById(@NonNull Long bookId) {
        final Optional<Book> optBook = bookRepository.findById(bookId);
        if (optBook.isPresent()) {
            final Book book = optBook.get();
            System.out.printf("");
        }
        return optBook;
    }

    @Override
    public Book getByIdOrThrown(@NonNull Long bookId) {
        return getById(bookId).orElseThrow(notFoundException("Книга не найдена {0}", bookId));
    }

    @Override
    @Transactional
    public Book update(@NonNull Book book) {
        final Book oldBook = bookRepository.findById(book.getId()).orElseThrow();
        oldBook.setTitle(book.getTitle());
        return oldBook;
    }

}

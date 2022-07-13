package dev.struchkov.library.data.jpa.impl;

import dev.struchkov.library.context.repository.BookRepository;
import dev.struchkov.library.data.jpa.rep.BookJpaRepository;
import dev.struchkov.library.domain.entity.Book;
import dev.struchkov.library.domain.filter.BookFilter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final BookJpaRepository jpaRepository;

    @Override
    public Optional<Book> findById(@NonNull Long bookId) {
        return jpaRepository.findById(bookId);
    }

    @Override
    public List<Book> findByPublicationDateBetween(@NonNull LocalDate from, @NonNull LocalDate to) {
        return jpaRepository.findAllByPublicationDateBetween(from, to);
    }

    @Override
    public List<Book> findByAuthorNickname(@NonNull String authorNickName) {
        return jpaRepository.findAllByAuthorNicknameLikeIgnoreCase('%' + authorNickName + '%');
    }

//    @Override
//    public List<Book> findByAuthorNickname(@NonNull String authorNickName) {
//        final List<BookMinView> bookMinViews = jpaRepository.findAllByAuthorNicknameLikeIgnoreCase('%' + authorNickName + '%');
//        return Collections.emptyList();
//    }

    @Override
    public List<Book> filter(@NonNull BookFilter filter) {
        Specification<Book> titleSpec = null;
        if (filter.getTitle() != null) {
            titleSpec = (root, query, cb) -> cb.like(cb.lower(root.get("title")), filter.getTitle());
        }

        final LocalDate dateFrom = filter.getPublicationDateFrom();
        final LocalDate dateTo = filter.getPublicationDateTo();
        Specification<Book> dateSpec = null;
        if (dateFrom != null && dateTo != null) {
            dateSpec = (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("publicationDate"), dateFrom, dateTo);
        }

        final List<Specification<Book>> specifications = Stream.of(titleSpec, dateSpec)
                .filter(Objects::nonNull)
                .toList();

        final Specification<Book> finalSpec;
        if (specifications.isEmpty()) {
            return Collections.emptyList();
        } else if (specifications.size() > 1) {
            finalSpec = Specification.where(specifications.get(0)).and(specifications.get(1));
        } else {
            finalSpec = Specification.where(specifications.get(0));
        }

        return jpaRepository.findAll(finalSpec);
    }

    @Override
    public List<Book> findByAuthorLastName(@NonNull String lastName) {
        return jpaRepository.findByAuthorLastName(lastName);
    }

}

package dev.struchkov.library.data.jpa.rep;

import dev.struchkov.library.domain.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookJpaRepository extends JpaRepositoryImplementation<Book, Long> {

    List<Book> findAllByPublicationDateBetween(LocalDate from, LocalDate to);

    List<Book> findAllByAuthorNicknameLikeIgnoreCase(String nickname);

    @Query("SELECT b FROM Book b WHERE lower(b.author.lastName) LIKE %:lastName%")
    List<Book> findByAuthorLastName(@Param("lastName") String lastName);

//    List<BookMinView> findAllByAuthorNicknameLikeIgnoreCase(String nickname);

}

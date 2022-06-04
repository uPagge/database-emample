package dev.struchkov.library.data.template.crud;

import dev.struchkov.library.domain.entity.Book;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookCrudRepository extends CrudRepository<Book, Long> {

    List<Book> findAllByPublicationDateBetween(LocalDate from, LocalDate to);

    @Query("""
            SELECT * FROM book LEFT JOIN author a on a.id = book.author
            WHERE UPPER(a.nickname) LIKE UPPER(CONCAT('%',:authorNickName,'%'))
            """)
    List<Book> findByAuthorNickname(@Param("authorNickName") String authorNickName);

}

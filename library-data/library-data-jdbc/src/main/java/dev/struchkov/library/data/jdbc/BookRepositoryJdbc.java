package dev.struchkov.library.data.jdbc;

import dev.struchkov.library.context.repository.BookRepository;
import dev.struchkov.library.domain.BookStatus;
import dev.struchkov.library.domain.entity.Book;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class BookRepositoryJdbc implements BookRepository {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/library";
    private static final String DB_USER = "postgres";
    private static final String DB_PASS = "121314Ma";
    private static final String SELECT_WHERE = "SELECT * FROM book WHERE book.id = ?";

    @Override
    public Optional<Book> findById(@NonNull Long bookId) {
        try (
                Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
                PreparedStatement stm = con.prepareStatement(SELECT_WHERE)
        ) {
            stm.setLong(1, bookId);
            final ResultSet resultSet = stm.executeQuery();
            if (resultSet.next()) {
                final Book book = new Book();
                book.setId(resultSet.getLong("id"));
                book.setTitle(resultSet.getString("title"));
                book.setBookStatus(BookStatus.valueOf(resultSet.getString("status")));
                book.setIsbn(resultSet.getString("isbn"));
                book.setDescription(resultSet.getString("description"));
                return Optional.of(book);
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<Book> findByPublicationDateBetween(@NonNull LocalDate from, @NonNull LocalDate to) {
        return Collections.emptyList();
    }

}

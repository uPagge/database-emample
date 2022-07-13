package dev.struchkov.library.web.convert;

import dev.struchkov.library.domain.entity.Book;
import dev.struchkov.library.web.dto.BookDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToConvertBook implements Converter<BookDto, Book> {

    @Override
    public Book convert(BookDto source) {
        if (source != null) {
            final Book book = new Book();
            book.setId(source.getId());
            book.setBookStatus(source.getBookStatus());
            book.setTitle(source.getTitle());
            book.setPublicationDate(source.getPublicationDate());
            book.setDescription(source.getDescription());
            book.setIsbn(source.getIsbn());
            return book;
        }
        return null;
    }

}

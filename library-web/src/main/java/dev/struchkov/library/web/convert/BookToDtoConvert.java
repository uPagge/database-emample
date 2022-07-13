package dev.struchkov.library.web.convert;

import dev.struchkov.library.domain.entity.Book;
import dev.struchkov.library.web.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookToDtoConvert implements Converter<Book, BookDto> {

    private final AuthorToDtoConverter authorToDtoConverter;

    @Override
    public BookDto convert(Book source) {
        if (source != null) {
            final BookDto bookDto = new BookDto();
            bookDto.setId(source.getId());
            bookDto.setBookStatus(source.getBookStatus());
            bookDto.setDescription(source.getDescription());
            bookDto.setIsbn(source.getIsbn());
            bookDto.setPublicationDate(source.getPublicationDate());
            bookDto.setTitle(source.getTitle());
            bookDto.setAuthorId(source.getAuthorId());
            bookDto.setAuthor(authorToDtoConverter.convert(source.getAuthor()));
            return bookDto;
        }
        return null;
    }

}

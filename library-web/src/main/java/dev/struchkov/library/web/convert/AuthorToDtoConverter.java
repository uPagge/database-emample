package dev.struchkov.library.web.convert;

import dev.struchkov.library.domain.entity.Author;
import dev.struchkov.library.web.dto.AuthorDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AuthorToDtoConverter implements Converter<Author, AuthorDto> {

    @Override
    public AuthorDto convert(Author source) {
        if (source != null) {
            final AuthorDto authorDto = new AuthorDto();
            authorDto.setId(source.getId());
            authorDto.setFirstName(source.getFirstName());
            authorDto.setLastName(source.getLastName());
            authorDto.setBirthDate(source.getBirthDate());

            authorDto.setNickname(source.getNickname());
            return authorDto;
        }
        return null;
    }

}

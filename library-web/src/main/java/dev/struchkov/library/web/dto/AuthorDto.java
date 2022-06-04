package dev.struchkov.library.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthorDto extends PersonDto {

    private String nickname;

    private List<BookDto> books;

}

package dev.struchkov.library.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PersonDto {

    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

}

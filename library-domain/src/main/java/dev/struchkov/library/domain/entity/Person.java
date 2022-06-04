package dev.struchkov.library.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.time.LocalDate;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public abstract class Person extends BasicEntity {

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

}

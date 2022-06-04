package dev.struchkov.library.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class PubHouse extends BasicEntity {

    private String name;

    private LocalDate foundingDate;

    private List<Manager> managers;

}

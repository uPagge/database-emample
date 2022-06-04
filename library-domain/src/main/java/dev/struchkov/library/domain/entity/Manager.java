package dev.struchkov.library.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;

@Getter
@Setter
@PrimaryKeyJoinColumn(name = "id")
public class Manager extends Person {

    private Long pubHouseId;

    private List<Author> authors;

}

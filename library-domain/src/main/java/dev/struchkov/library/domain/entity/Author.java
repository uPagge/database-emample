package dev.struchkov.library.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;

@Getter
@Setter
@Table("author")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@PrimaryKeyJoinColumn(name = "id")
public class Author extends Person {

    @Column("nickname")
    private String nickname;

    @MappedCollection
    private List<Book> books;

}

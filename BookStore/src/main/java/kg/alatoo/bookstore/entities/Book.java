package kg.alatoo.bookstore.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
//@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
//@Value
@Builder
@Entity
public class Book {

    @ToString.Include
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue
    Long id;
    @ToString.Include
    private String title;
    private String description;
    @ToString.Include
    private String isbn;

    @ManyToMany
    private List<Author> authors;
    @ManyToOne
    private Publisher publisher;


}

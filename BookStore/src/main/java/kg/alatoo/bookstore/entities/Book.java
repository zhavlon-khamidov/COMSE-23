package kg.alatoo.bookstore.entities;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
@Schema(description = "The book schema", title = "Book")
public class Book {

    @ToString.Include
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue
    @Schema(description = "id of book", $id = "primary key", $schema = "book")
    private Long id;

    @ToString.Include
    @NotNull(message = "Title must not be null")
    @NotEmpty(message = "Title must not be empty")
    @NotBlank(message = "Title must not be blank")
    @Column(nullable = false, length = 20)
    private String title;

    private String description;

    @ToString.Include
    private String isbn;

    @ManyToMany
    private List<Author> authors;

    @ManyToOne
    private Publisher publisher;


}

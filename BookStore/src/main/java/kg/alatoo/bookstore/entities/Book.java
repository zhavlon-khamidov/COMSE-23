package kg.alatoo.bookstore.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

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
    private String author;
    private String publisher;
    @Builder.Default
    private String isbn = UUID.randomUUID().toString();

}

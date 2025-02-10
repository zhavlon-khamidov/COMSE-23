package kg.alatoo.bookstore.entities;


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
public class Book {

    @ToString.Include
    @EqualsAndHashCode.Include
    @NonNull
    Integer id;
    @ToString.Include
    private String title;

    private String description;
    private String author;
    private String publisher;
    @Builder.Default
    private String isbn = UUID.randomUUID().toString();


    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Book setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }
}

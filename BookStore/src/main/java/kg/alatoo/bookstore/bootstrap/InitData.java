package kg.alatoo.bookstore.bootstrap;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import kg.alatoo.bookstore.entities.Author;
import kg.alatoo.bookstore.entities.Book;
import kg.alatoo.bookstore.entities.Publisher;
import kg.alatoo.bookstore.repositories.AuthorRepository;
import kg.alatoo.bookstore.repositories.BookRepository;
import kg.alatoo.bookstore.repositories.PublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Slf4j
@RequiredArgsConstructor
public class InitData {

    private String myProperty;

    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;

    @PostConstruct
    public void init(){
        log.warn("Init data");

        Publisher alatoo = Publisher.builder()
                .name("Alatoo")
                .address("Ankara 1/8")
                .build();

        Author author1 = Author.builder()
                .firstName("Author1")
                .build();

        Author author2 = Author.builder()
                .firstName("Author2")
                .build();

        Book book1 = Book.builder()
                .title("Book1")
                .isbn("413213543213")
                .publisher(alatoo)
                .authors(List.of(author1, author2))
                .description("Book 1 Description")
                .build();

        Book book2 = Book.builder()
                .title("Book2")
                .isbn("32435435753")
                .publisher(alatoo)
                .authors(List.of(author1))
                .description("Book 2 Description")
                .build();

        Book book3 = Book.builder()
                .title("Book3")
                .isbn("543548351354")
                .publisher(alatoo)
                .authors(List.of(author2))
                .description("Book 3 Description")
                .build();


        authorRepository.save(author1);
        authorRepository.save(author2);

        publisherRepository.save(alatoo);
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
    }


    @PreDestroy
    public void destroy(){
        log.warn("Destroy data");
    }

    @Value("${my.value}")
    public InitData setMyProperty(String myProperty) {
        log.warn("setting myProperty={}", myProperty);
        this.myProperty = myProperty;
        return this;
    }
}

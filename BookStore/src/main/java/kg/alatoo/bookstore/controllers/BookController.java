package kg.alatoo.bookstore.controllers;

import kg.alatoo.bookstore.entities.Book;
import kg.alatoo.bookstore.repositories.BookRepository;
import kg.alatoo.bookstore.services.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/api/v1/book/")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        log.debug("Creating the Book {}", book.toString());
        Book saved = bookRepository.save(book);
        log.debug("Book {} created", saved);
//        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        return ResponseEntity
                .created(URI.create("/api/v1/book/" + saved.getId()))
                .header("MyCustomHeader", "CustomHeaderValue")
                .build();
    }


    @PutMapping("{id}")
    public void updateBook(@PathVariable Long id, @RequestBody Book book) {

        bookService.updateBook(id, book);

    }
}

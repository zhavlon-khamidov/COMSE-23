package kg.alatoo.bookstore.controllers;

import kg.alatoo.bookstore.dto.BookListDto;
import kg.alatoo.bookstore.entities.Book;
import kg.alatoo.bookstore.services.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(book);
    }


    @GetMapping
    public List<BookListDto> getAllBooks(
            @RequestParam(value = "publisher", required = false) String publisher
    ) {
        return bookService.getBooks(publisher);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        log.debug("Creating the Book {}", book.toString());
        Book saved = bookService.addBook(book);
        log.debug("Book {} created", saved);
//        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        return ResponseEntity
                .created(URI.create("/api/v1/book/" + saved.getId()))
                .header("MyCustomHeader", "CustomHeaderValue")
                .build();
    }


    @PutMapping("{id}")
    public void updateBook(@PathVariable Long id, @RequestBody Book book) {
        bookService.putBook(id, book);

    }
}

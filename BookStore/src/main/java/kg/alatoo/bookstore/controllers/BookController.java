package kg.alatoo.bookstore.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import kg.alatoo.bookstore.dto.BookListDto;
import kg.alatoo.bookstore.entities.Book;
import kg.alatoo.bookstore.services.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        //TODO: solve an issue with infinite loop providing json objects
        return ResponseEntity.ok().body(bookService.getBookById(id));
    }


    @GetMapping
    @Operation(summary = "Provides all books by page",
            description = "Provides all books by page, with default " +
                    "first page and 10 books in each page",
            responses = {@ApiResponse(responseCode = "404", description = "Not found")},
            parameters = {
                    @Parameter(name = "pageNumber",
                        description = "Page number to take (0 indexed)"),
                    @Parameter(name = "page_size",
                            description = "wrong page size name"
                    )
            })
    public Page<BookListDto> getAllBooks(
            @RequestParam(value = "publisher", required = false) String publisher,
            @RequestParam(required = false) Integer pageNumber,
            @RequestParam(required = false)
                @Parameter(description = "number of elements on each page") Integer pageSize
    ) {
        return bookService.getBooks(publisher, pageNumber, pageSize);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody @Validated Book book) {
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

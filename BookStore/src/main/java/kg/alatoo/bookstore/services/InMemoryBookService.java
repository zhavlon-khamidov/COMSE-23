package kg.alatoo.bookstore.services;

import kg.alatoo.bookstore.entities.Book;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InMemoryBookService implements BookService {

    private static long nextId = 1;

    Map<Long, Book> books = new HashMap<>();

    public InMemoryBookService() {
        Book book1 = Book.builder()
                .id(nextId++)
                .title("Book 1")
                .author("Author 1")
                .description("First book")
                .isbn("3524365435")
                .build();

        Book book2 = Book.builder()
                .id(nextId++)
                .title("Book 2")
                .author("Author 2")
                .description("Second book")
                .isbn("5341355")
                .build();

        Book book3 = Book.builder()
                .id(nextId++)
                .title("Book 3")
                .author("Author 3")
                .description("Third book")
                .isbn("54684864")
                .build();
    }

    @Override
    public Book updateBook(Long id, Book book) {

        /* TODO: check for existence of book, check book object has the id value,
         if it has the id value does it match with id attribute*/

        return null;
    }
}

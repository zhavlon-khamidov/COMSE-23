package kg.alatoo.bookstore.services;

import kg.alatoo.bookstore.entities.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
                .publisher("Publisher1")
                .isbn("3524365435")
                .build();

        Book book2 = Book.builder()
                .id(nextId++)
                .title("Book 2")
                .author("Author 2")
                .description("Second book")
                .publisher("Publisher2")
                .isbn("5341355")
                .build();

        Book book3 = Book.builder()
                .id(nextId++)
                .title("Book 3")
                .author("Author 3")
                .description("Third book")
                .publisher("Publisher1")
                .isbn("54684864")
                .build();

        books.put(book1.getId(), book1);
        books.put(book2.getId(), book2);
        books.put(book3.getId(), book3);
    }

    @Override
    public Book addBook(Book book) {
        book.setId(nextId++);
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public Book putBook(Long id, Book book) {

        if (!books.containsKey(id)) {
            throw new IllegalArgumentException("Book not found");
        }
        if (book.getId() != null && book.getId() != 0 & book.getId() != id) {
            throw new IllegalArgumentException("Book id mismatch");
        }
        book.setId(id);
        books.put(book.getId(), book);

        return book;
    }

    @Override
    public Book patchBook(Long id, Book book) {
        if (!books.containsKey(id)) {
            throw new IllegalArgumentException("Book not found");
        }
        Book oldBook = books.get(id);
        //TODO: HW write the code for PATCH method

        return oldBook;
    }

    @Override
    public List<Book> getBooks(String publisher) {
        if (publisher != null) {
            final String finalPublisher  = publisher.toLowerCase();
            return books.values()
                    .stream()
                    .filter(b -> b.getPublisher().toLowerCase().equals(finalPublisher))
                    .collect(Collectors.toList());
        }
        return new ArrayList<>(books.values());
    }
}

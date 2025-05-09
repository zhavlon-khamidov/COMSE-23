package kg.alatoo.bookstore.services;

import kg.alatoo.bookstore.NotFoundException;
import kg.alatoo.bookstore.dto.BookListDto;
import kg.alatoo.bookstore.entities.Book;
import kg.alatoo.bookstore.entities.Publisher;
import kg.alatoo.bookstore.mappers.BookMapper;
import kg.alatoo.bookstore.mappers.BookMapstructMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InMemoryBookService implements BookService {

    private static long bookNextId = 1;
    private static long publisherNextId = 1;

    private final BookMapper bookMapper;
    private final BookMapstructMapper bookMapstructMapper;

    Map<Long, Book> books = new HashMap<>();

    public InMemoryBookService(BookMapper bookMapper, BookMapstructMapper bookMapstructMapper) {
        this.bookMapper = bookMapper;
        this.bookMapstructMapper = bookMapstructMapper;

        Publisher alatooPublisher = Publisher.builder()
                .name("Alatoo Public Books")
                .address("Ankara 1/8")
                .id(publisherNextId++)
                .build();

        Publisher anotherPublisher = Publisher.builder()
                .name("Another Public Books")
                .address("Another Public Books")
                .id(bookNextId++)
                .build();

        Book book1 = Book.builder()
                .id(bookNextId++)
                .title("Book 1")
                .description("First book")
                .publisher(alatooPublisher)
                .isbn("3524365435")
                .build();

        Book book2 = Book.builder()
                .id(bookNextId++)
                .title("Book 2")
                .description("Second book")
                .publisher(anotherPublisher)
                .isbn("5341355")
                .build();

        Book book3 = Book.builder()
                .id(bookNextId++)
                .title("Book 3")
                .description("Third book")
                .publisher(alatooPublisher)
                .isbn("54684864")
                .build();

        books.put(book1.getId(), book1);
        books.put(book2.getId(), book2);
        books.put(book3.getId(), book3);
    }

    @Override
    public Book addBook(Book book) {
        book.setId(bookNextId++);
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public Book putBook(Long id, Book book) {

        if (!books.containsKey(id)) {
            throw new IllegalArgumentException("Book not found");
        }
        if (book.getId() != null && book.getId() != 0 & !book.getId().equals(id)) {
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
    public Page<BookListDto> getBooks(String publisher, Integer pageNumber, Integer pageSize) {

        List<Book> booksForReturn;
        if (publisher != null) {
            final String finalPublisher  = publisher.toLowerCase();
            /*ArrayList<Book> booksToReturn = new ArrayList<>();
            for (Book book : books.values()) {
                if (book.getAuthor().toLowerCase().contains(finalPublisher)) {
                    booksToReturn.add(book);
                }
            }
            return booksToReturn;*/
            booksForReturn = books.values()
                    .stream()
                    .filter(b -> b.getPublisher().getName().toLowerCase().equals(finalPublisher))
                    .toList();
        } else {
            booksForReturn = new ArrayList<>(books.values());
        }

        return new PageImpl<>(bookMapper.toBookListDtos(booksForReturn)); // converts to BookListDto each Book
    }

    @Override
    public Book getBookById(Long id) {
        if (!books.containsKey(id)) {
            throw new NotFoundException("Book with id " + id + " not found");
        }
        return books.get(id);
    }
}

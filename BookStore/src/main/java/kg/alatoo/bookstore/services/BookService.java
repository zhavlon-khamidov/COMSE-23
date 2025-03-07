package kg.alatoo.bookstore.services;

import kg.alatoo.bookstore.dto.BookListDto;
import kg.alatoo.bookstore.entities.Book;
import org.springframework.data.domain.Page;

public interface BookService {
    Book addBook(Book book);

    Book putBook(Long id, Book book);

    Book patchBook(Long id, Book book);

    Page<BookListDto> getBooks(String publisher, Integer pageNumber, Integer pageSize);

    Book getBookById(Long id);
}

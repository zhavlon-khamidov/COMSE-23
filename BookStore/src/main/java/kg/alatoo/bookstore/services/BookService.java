package kg.alatoo.bookstore.services;

import kg.alatoo.bookstore.dto.BookListDto;
import kg.alatoo.bookstore.entities.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);

    Book putBook(Long id, Book book);

    Book patchBook(Long id, Book book);

    List<BookListDto> getBooks(String publisher);

    Book getBookById(Long id);
}

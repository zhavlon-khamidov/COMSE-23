package kg.alatoo.bookstore.services;

import kg.alatoo.bookstore.entities.Book;

public interface BookService {
    Book updateBook(Long id, Book book);
}

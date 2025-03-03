package kg.alatoo.bookstore.services;

import kg.alatoo.bookstore.NotFoundException;
import kg.alatoo.bookstore.dto.BookListDto;
import kg.alatoo.bookstore.entities.Book;
import kg.alatoo.bookstore.mappers.BookMapper;
import kg.alatoo.bookstore.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Primary
public class DatabaseBookService implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public Book addBook(Book book) {
        return null;
    }

    @Override
    public Book putBook(Long id, Book book) {
        return null;
    }

    @Override
    public Book patchBook(Long id, Book book) {
        return null;
    }

    @Override
    public List<BookListDto> getBooks(String publisher) {
        if (publisher != null) {
            //TODO: get books by publisher name
            return List.of();
        } else {
            ArrayList<Book> books = new ArrayList<>();
            bookRepository.findAll().forEach(books::add);
            return bookMapper.toBookListDtos(books);
        }
    }

    @Override
    public Book getBookById(Long id) {
        /*Book book = bookRepository.getById(id);
        if (book != null) {
            return book;
        }else {
            throw new NotFoundException("Book with id " + id + " not found");
        }*/

        return bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found"));
    }
}

package kg.alatoo.bookstore.services;

import kg.alatoo.bookstore.NotFoundException;
import kg.alatoo.bookstore.dto.BookListDto;
import kg.alatoo.bookstore.entities.Book;
import kg.alatoo.bookstore.entities.Publisher;
import kg.alatoo.bookstore.mappers.BookMapper;
import kg.alatoo.bookstore.repositories.BookRepository;
import kg.alatoo.bookstore.repositories.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Primary
public class DatabaseBookService implements BookService {
    private static final Integer DEFAULT_PAGE_SIZE = 10;
    private static final Integer DEFAULT_PAGE_NUMBER = 0;

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final PublisherRepository publisherRepository;

    @Override
    public Book addBook(Book book) {
        if (book.getId()!=null && book.getId()!=0) {
            throw new IllegalArgumentException("book id should not be provided for creating new book");
        }
        return bookRepository.save(book);
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
    public Page<BookListDto> getBooks(String publisher, Integer pageNumber, Integer pageSize) {
        int requestedPageNumber = pageNumber == null ? DEFAULT_PAGE_NUMBER : pageNumber;
        int requestedPageSize = pageSize == null ? DEFAULT_PAGE_SIZE : pageSize;

        Pageable pageRequest = PageRequest.of(requestedPageNumber, requestedPageSize);
        if (publisher != null) {
            //TODO: get books by publisher name
            List<Publisher> byName = publisherRepository.findByName(publisher);
            if (byName.isEmpty()) {
                return Page.empty();
            }
            bookRepository.getBooksByPublisher(byName.get(0), pageRequest);
            return Page.empty();
        } else {
            return bookRepository
                    .findAll(pageRequest)
                    .map(bookMapper::toBookListDto);
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

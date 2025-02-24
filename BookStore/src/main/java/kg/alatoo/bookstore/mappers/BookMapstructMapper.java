package kg.alatoo.bookstore.mappers;

import kg.alatoo.bookstore.dto.BookDto;
import kg.alatoo.bookstore.dto.BookListDto;
import kg.alatoo.bookstore.entities.Author;
import kg.alatoo.bookstore.entities.Book;
import kg.alatoo.bookstore.entities.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface BookMapstructMapper {

    BookListDto toBookListDto(Book book);

    List<BookListDto> toBookListDtos(List<Book> books);

    @Mapping(source = "title", target = "name")
    BookDto toBookDto(Book book);


    default String publisherToString(Publisher publisher) {
        return publisher.getName();
    }

    default String authorAsString(Author author) {
        return author.getFirstName() + " " + author.getLastName();
    }
}

package kg.alatoo.bookstore.mappers;

import kg.alatoo.bookstore.dto.BookListDto;
import kg.alatoo.bookstore.entities.Author;
import kg.alatoo.bookstore.entities.Book;
import kg.alatoo.bookstore.entities.Publisher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BookMapperImpl implements BookMapper {
    @Override
    public BookListDto toBookListDto(Book book) {

        List<String> authorsAsString = new ArrayList<>();
        List<Author> authors = book
                .getAuthors();
        if (authors != null) {
            authorsAsString = authors
                    .stream()
                    .map(a -> a.getFirstName() + " " + a.getLastName())
                    .toList();
        }


        return BookListDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .publisher(
                        Optional.of(book.getPublisher())
                                .orElse(new Publisher())
                                .getName()
                )
                .authors(authorsAsString)
                .build();
    }
}

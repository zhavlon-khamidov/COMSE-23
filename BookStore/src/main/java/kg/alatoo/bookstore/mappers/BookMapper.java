package kg.alatoo.bookstore.mappers;

import kg.alatoo.bookstore.dto.BookListDto;
import kg.alatoo.bookstore.entities.Book;

import java.util.List;

public interface BookMapper {

    BookListDto toBookListDto(Book book);

    default List<BookListDto> toBookListDtos(List<Book> books) {
        return books.stream().map(this::toBookListDto)
                .toList();
    }
}

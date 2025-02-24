package kg.alatoo.bookstore.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BookListDto {

    private Long id;
    private String title;
    private String isbn;
    private List<String> authors;
    private String publisher;
}

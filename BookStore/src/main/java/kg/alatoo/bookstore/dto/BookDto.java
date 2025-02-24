package kg.alatoo.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BookDto {
    private Long id;
    private String name;
    private String description;
    private String isbn;
//    private List<AuthorDto> authors;
//    private PublisherDto publisher;
}

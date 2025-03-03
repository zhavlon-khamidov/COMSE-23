package kg.alatoo.bookstore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

}

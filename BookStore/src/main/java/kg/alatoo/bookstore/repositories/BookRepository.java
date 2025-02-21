package kg.alatoo.bookstore.repositories;

import kg.alatoo.bookstore.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}

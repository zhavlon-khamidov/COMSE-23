package kg.alatoo.bookstore.repositories;

import kg.alatoo.bookstore.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}

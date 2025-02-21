package kg.alatoo.bookstore.repositories;

import kg.alatoo.bookstore.entities.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}

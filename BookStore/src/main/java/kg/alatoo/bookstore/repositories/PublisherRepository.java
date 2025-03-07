package kg.alatoo.bookstore.repositories;

import kg.alatoo.bookstore.entities.Publisher;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    List<Publisher> findByName(String name);
}

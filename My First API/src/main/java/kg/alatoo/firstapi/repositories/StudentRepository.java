package kg.alatoo.firstapi.repositories;

import kg.alatoo.firstapi.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}

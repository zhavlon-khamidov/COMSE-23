package kg.alatoo.firstapi.bootstrap;

import kg.alatoo.firstapi.entities.Student;
import kg.alatoo.firstapi.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public DataInit(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Student student1 = new Student("Ahmatbek", "Tursunbaev");
        Student student2 = new Student("Azamat", "Bazarmatov");

        studentRepository.save(student1);
        studentRepository.save(student2);

    }
}

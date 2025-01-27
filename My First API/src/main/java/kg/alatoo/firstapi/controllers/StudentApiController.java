package kg.alatoo.firstapi.controllers;

import kg.alatoo.firstapi.entities.Student;
import kg.alatoo.firstapi.repositories.StudentRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentApiController {

    private final StudentRepository studentRepository;

    public StudentApiController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/api/v1/student")
    public Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/api/v1/student/{id}")
    public Student getStudent(@PathVariable("id") long studentId) {
        return studentRepository.findById(studentId).orElseThrow();
    }


    @PostMapping("/api/v1/student")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("/api/v1/student/{id}")
    public Student updateStudent() {
        return null;
    }

    @DeleteMapping("/api/v1/student/{id}")
    public void deleteStudent(@PathVariable("id") long studentId) {

    }

}

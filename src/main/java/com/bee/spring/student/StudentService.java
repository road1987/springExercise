package com.bee.spring.student;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        Optional<Student> optStudentOptional = studentRepository.getStudentByEmail(student.getEmail());
        optStudentOptional.ifPresent(item -> {
            throw new IllegalStateException("Email taken!");
        });
        studentRepository.save(student);
        return student;
    }

    public Student deleteStudent(Student student) {
        studentRepository.delete(student);
        return student;
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public void deleteStudentById(Long id) {
        Boolean isExist = studentRepository.existsById(id);
        if (!isExist) {
            throw new IllegalStateException("Student with id " + id + " is not existed!");
        }
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Student student) {
        Boolean isExist = studentRepository.existsById(student.getId());
        if (!isExist) {
            throw new IllegalStateException("Student with id " + student.getId() + " is not existed!");
        }
        studentRepository.save(student);
        return student;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }


}

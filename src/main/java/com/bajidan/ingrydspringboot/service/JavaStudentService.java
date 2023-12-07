package com.bajidan.ingrydspringboot.service;

import com.bajidan.ingrydspringboot.exception_handler.StudentNotFoundException;
import com.bajidan.ingrydspringboot.model.JavaStudent;
import com.bajidan.ingrydspringboot.repository.JavaStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JavaStudentService {

    @Autowired
    private JavaStudentRepository studentRepository;

    public List<JavaStudent> getAllStudent() {
        return studentRepository.findAll();
    }

    public ResponseEntity<JavaStudent> addStudent(JavaStudent student) {

        return ResponseEntity.ok(studentRepository.save(student));
    }

    public JavaStudent getStudentById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

    public JavaStudent getStudentByEmail(String email) {
        return studentRepository.findByEmail(email)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

    public String updateStudent(Integer id, JavaStudent student) {
        JavaStudent currentStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
        student.setId(currentStudent.getId());
        studentRepository.save(new JavaStudent(student));
        return "Successfully update student";
    }

    public String deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
        return "Student deleted successfully";
    }
}

package com.bajidan.ingrydspringboot.controller;

import com.bajidan.ingrydspringboot.model.JavaStudent;
import com.bajidan.ingrydspringboot.model.JavaStudentResource;
import com.bajidan.ingrydspringboot.service.JavaStudentService;
import com.jayway.jsonpath.Criteria;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class JavaStudentController {

    @Autowired
    private JavaStudentService studentService;

    @GetMapping("/students/getAll")
    @ResponseStatus(HttpStatus.OK)

    public List<JavaStudent> getAllStudent() {
        //\CriteriaBuilder builder =
        return studentService.getAllStudent();
    }

    @GetMapping("/student/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public JavaStudent getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/student/getByEmail/{email}")
    @ResponseStatus(HttpStatus.OK)
    public JavaStudent getStudentByEmail(@PathVariable String email) {
        return studentService.getStudentByEmail(email);
    }
    @PostMapping("/add")
    public ResponseEntity<JavaStudent> addStudent(@Valid @RequestBody JavaStudent student) {
        return studentService.addStudent(student);
    }


    @PutMapping("/student/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateStudent(@PathVariable Integer id, @RequestBody JavaStudent student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/student/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteStudentById(@PathVariable Integer id) {
        return studentService.deleteStudentById(id);
    }

    @GetMapping("/student/resource/{id}")
    public JavaStudentResource getStudent(@PathVariable Integer id) {
        JavaStudent javaStudent = studentService.getStudentById(id);

        JavaStudentResource studentResource = new JavaStudentResource();
        studentResource.setJavaStudent(javaStudent);

        Link selfLink1 = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(JavaStudentController.class)
                        .getStudent(id)).withSelfRel();

        Link link = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder
                        .methodOn(JavaStudentController.class)
                        .getAllStudent()).withRel("getAllStudent");

        studentResource.add(selfLink1, link);

        return studentResource;

    }

}

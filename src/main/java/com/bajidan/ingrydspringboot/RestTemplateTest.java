package com.bajidan.ingrydspringboot;

import com.bajidan.ingrydspringboot.model.JavaStudent;
import com.bajidan.ingrydspringboot.model.JavaStudentResource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.List;

public class RestTemplateTest {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String urlGetAllStudent = "http://localhost:8081/api/v1/students/getAll";
        String urlGetById = "http://localhost:8081/api/v1/student/getById/3";
        String urlGetByEmail = "http://localhost:8081/api/v1/student/getByEmail/brain@mail";
        String urlResource = "http://localhost:8081/api/v1/student/resource/3";
        String urlUpdate = "http://localhost:8081/api/v1/student/update/10";
        String urlAddStudent = "http://localhost:8081/api/v1/add";
        String urlDelete = "http://localhost:8081/api/v1/student/delete/8";


        // Get All student
        List<JavaStudent> studentList = restTemplate
                .exchange(urlGetAllStudent, HttpMethod.GET,
                        null, new ParameterizedTypeReference<List<JavaStudent>>() {
        }).getBody();

        assert studentList != null;
        // Print the list of student
        studentList.forEach(System.out::println);


        // Get Student with id 3
        JavaStudent javaStudent = restTemplate.getForObject(urlGetById, JavaStudent.class);
        System.out.println(javaStudent);

        // Get Student with email brain@mail
        JavaStudent javaStudent1 = restTemplate.getForObject(urlGetByEmail, JavaStudent.class);
        System.out.println(javaStudent1);


        // Add student to the database
        JavaStudent student = new JavaStudent(
                "Kayode", "Olanrewaju", "male", 39, "sirk@mail", "Java0099");

        ResponseEntity<JavaStudent> response = restTemplate.postForEntity(urlAddStudent, student, JavaStudent.class);
        JavaStudent extracted = response.getBody();
        System.out.println(extracted);

        // Get resources
        JavaStudentResource javaStudentResource = restTemplate.getForObject(urlResource, JavaStudentResource.class);
        System.out.println(javaStudentResource);

        // Edit student
        JavaStudent student1 = new JavaStudent(
                "Lanre", "Olarewaju", "male", 40, "ola@mail", "Java0077");
        restTemplate.put(urlUpdate, student1);

        //Delete Student
        restTemplate.delete(urlDelete);

    }
}

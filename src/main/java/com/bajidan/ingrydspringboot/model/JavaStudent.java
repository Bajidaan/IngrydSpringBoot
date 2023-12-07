package com.bajidan.ingrydspringboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "java_student", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class JavaStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "field cannot be blank")
    @Length(min = 3, message = "First name cannot be less than 3 character")
    //@Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "field cannot be blank")
    @Length(min = 3, message = "Last name cannot be less than 3 character")
    @Column(name = "last_name")
    private String lastName;

    private String sex;


    @Min(value = 18, message = "You must be 18 years and above")
    @Max(value = 70, message = "You are too old")
    private int age;

    @Email
    private String email;

    @Pattern(regexp = "Java[0-9]{4}", message = "course must be Java####")
    private String course;

    public JavaStudent(String firstName, String lastName, String sex, int age, String email, String course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    public JavaStudent(JavaStudent student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.lastName;
        this.sex = student.getSex();
        this.age = student.getAge();
        this.email = student.getEmail();
        this.course = student.getCourse();
    }

    public JavaStudent() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return String.format("{%n \"id\": %s%n" +
                "\"firstName\": \"%s\"%n" +
                "\"lastName\": \"%s\"%n" +
                "\"sex\": \"%s\"%n" +
                "\"age\": %d%n" +
                "\"email\": \"%s\"%n" +
                "\"course\": \"%s\"%n" +
                        "}", id, firstName,
                lastName, sex, age, email, course);

    }
}

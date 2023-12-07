package com.bajidan.ingrydspringboot.model;

import org.springframework.hateoas.RepresentationModel;

public class JavaStudentResource extends RepresentationModel<JavaStudentResource> {
    private JavaStudent javaStudent;

    public JavaStudent getJavaStudent() {
        return javaStudent;
    }

    public void setJavaStudent(JavaStudent javaStudent) {
        this.javaStudent = javaStudent;
    }
}

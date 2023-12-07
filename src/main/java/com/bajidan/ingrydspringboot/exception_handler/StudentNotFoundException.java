package com.bajidan.ingrydspringboot.exception_handler;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message) {
        super(message);
    }
}

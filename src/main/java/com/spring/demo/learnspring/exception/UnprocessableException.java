package com.spring.demo.learnspring.exception;

public class UnprocessableException extends  RuntimeException {
    public UnprocessableException(String message) {
        super(message);
    }
}

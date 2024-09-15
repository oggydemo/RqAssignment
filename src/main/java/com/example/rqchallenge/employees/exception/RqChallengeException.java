package com.example.rqchallenge.employees.exception;

import org.springframework.http.HttpStatus;

public class RqChallengeException extends RuntimeException {

        private final HttpStatus statusCode;
        private final String error;

    public RqChallengeException(HttpStatus statusCode, String error) {
        super(error);
        this.statusCode = statusCode;
        this.error = error;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public String getError() {
        return error;
    }
}

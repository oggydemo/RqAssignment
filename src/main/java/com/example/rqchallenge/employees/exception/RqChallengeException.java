package com.example.rqchallenge.employees.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

public class RqChallengeException extends RuntimeException {

        private HttpStatus statusCode;
        private String error;

    public RqChallengeException(HttpStatus statusCode, String error) {
        super(error);
        this.statusCode = statusCode;
        this.error = error;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

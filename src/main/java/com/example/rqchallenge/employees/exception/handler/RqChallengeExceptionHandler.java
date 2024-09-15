package com.example.rqchallenge.employees.exception.handler;

import com.example.rqchallenge.employees.exception.RqChallengeException;
import com.example.rqchallenge.employees.model.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RqChallengeExceptionHandler {

    // creating a logger
    Logger logger = LoggerFactory.getLogger(RqChallengeExceptionHandler.class);

    @ExceptionHandler(value = RqChallengeException.class)
    ResponseEntity<ErrorResponse> handleMyRestTemplateException(RqChallengeException ex, HttpServletRequest request) {
        logger.error("Error occurred while processing , received response from external API is : {}" , ex.getStatusCode());
        return new ResponseEntity<>(new ErrorResponse(ex, request.getRequestURI()), ex.getStatusCode());
    }

}

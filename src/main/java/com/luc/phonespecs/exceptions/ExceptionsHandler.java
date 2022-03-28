package com.luc.phonespecs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest) {
        ExceptionInfo exceptionInfo = new ExceptionInfo(
                ZonedDateTime.now(ZoneId.of("Z")),
                resourceNotFoundException.getCause().getMessage(),
                HttpStatus.NOT_FOUND,
                resourceNotFoundException.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionInfo, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConcurrentException.class)
    public ResponseEntity<?> handleConcurrentException(ConcurrentException concurrentException, WebRequest webRequest) {
        ExceptionInfo exceptionInfo = new ExceptionInfo(
                ZonedDateTime.now(ZoneId.of("Z")),
                concurrentException.getCause().getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                concurrentException.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(exceptionInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

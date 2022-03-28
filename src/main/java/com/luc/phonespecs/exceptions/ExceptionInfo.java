package com.luc.phonespecs.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class ExceptionInfo {

    private ZonedDateTime timestamp;
    private String cause;
    private HttpStatus httpStatus;
    private String message;
    private String details;
}

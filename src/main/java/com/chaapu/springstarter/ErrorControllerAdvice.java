package com.chaapu.springstarter;

import com.chaapu.springstarter.exceptions.ErrorResponse;
import com.chaapu.springstarter.exceptions.ResourceAlreadyExistsException;
import com.chaapu.springstarter.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorControllerAdvice {

    @ResponseBody
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<ErrorResponse> resourceNotFoundHandler(ResourceNotFoundException ex) {
        final ErrorResponse response = new ErrorResponse.ErrorResponseBuilder()
                .withStatus(HttpStatus.NOT_FOUND)
                .withErrorCode(HttpStatus.NOT_FOUND.value())
                .withMessage(ex.getMessage())
                .build();


        return new ResponseEntity<ErrorResponse>(response,
                new HttpHeaders(),
                HttpStatus.NOT_FOUND);

    }

    @ResponseBody
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    ResponseEntity<ErrorResponse> resourceAlreadyExistsHandler(ResourceAlreadyExistsException ex) {
        final ErrorResponse response = new ErrorResponse.ErrorResponseBuilder()
                .withStatus(HttpStatus.NOT_FOUND)
                .withErrorCode(HttpStatus.NOT_FOUND.value())
                .withMessage(ex.getMessage())
                .build();

        return new ResponseEntity<ErrorResponse>(response,
                new HttpHeaders(),
                HttpStatus.CONFLICT);

    }
}

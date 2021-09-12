package com.manager.exception;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Error> notFound(NotFoundException e) {
        return new ResponseEntity<>(createError(e, 404), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = EntityExistException.class)
    public ResponseEntity<Error> managerException(EntityExistException e) {
        return new ResponseEntity<>(createError(e, 409), HttpStatus.CONFLICT);
    }

    private Error createError(Exception e, int codeError) {
        Error error = new Error();
        error.setCode(codeError);
        error.setMessage(e.getMessage());
        return error;
    }
}

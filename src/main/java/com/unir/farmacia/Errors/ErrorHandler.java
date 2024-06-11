package com.unir.farmacia.Errors;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler
    public ResponseEntity<String> handleArithmeticException(ArithmeticException e) {
        return ResponseEntity.badRequest().body("Error: " + e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        return ResponseEntity.badRequest().body("Error: " + e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleConstraintViolationException(org.hibernate.exception.ConstraintViolationException e) {
        return ResponseEntity.badRequest().body("Error: " + e.getMessage());
    }

    @ExceptionHandler
    protected ResponseEntity<Object> handleException(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        ErrorResponse errorResponse = new ErrorResponse();
        List<ErrorField> errores = new ArrayList<>();
        fieldErrors.forEach((error)->{
            ErrorField err = new ErrorField();
            err.setField(((FieldError) error).getField());
			err.setMessage(error.getDefaultMessage());
			errores.add(err);
        });
        errorResponse.setMessage("Error en tipo de dato");
        errorResponse.setStatus(400);
		errorResponse.setTimestamp(new Date());
        errorResponse.setError(errores);
        return ResponseEntity.badRequest().body(errorResponse);
    }
}

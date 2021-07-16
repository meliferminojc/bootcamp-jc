package com.example.desafio_quality.exception.handler;

import com.example.desafio_quality.dto.exception.GenericExceptionDTO;
import com.example.desafio_quality.dto.exception.GenericExceptionFieldDTO;
import com.example.desafio_quality.exception.NotFoundException;
import com.example.desafio_quality.util.exception.FieldErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ApiHandlerException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> sellerNotFound(NotFoundException notFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GenericExceptionDTO(notFoundException.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> argumentNotValidHandler(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();

        List<FieldError> fieldErrors = result.getFieldErrors();
        GenericExceptionFieldDTO exceptions = FieldErrors.processFieldErrors(fieldErrors);

        return ResponseEntity.badRequest().body(exceptions);
    }
}

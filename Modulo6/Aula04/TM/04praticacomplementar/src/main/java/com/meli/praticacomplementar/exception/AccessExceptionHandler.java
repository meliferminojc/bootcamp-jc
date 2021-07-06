package com.meli.praticacomplementar.exception;

import com.meli.praticacomplementar.dtos.ExceptionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AccessExceptionHandler {

    @ExceptionHandler(AccessException.class)
    public ResponseEntity<?> accesExceptionHandler(AccessException e) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(e.getMessage()));
    }
}

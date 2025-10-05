package com.gamerdream.backend.Config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gamerdream.backend.Exceptions.CredenciaisInvalidasEx;
import com.gamerdream.backend.Exceptions.UsuarioNaoEncontradoEx;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsuarioNaoEncontradoEx.class)
    public ResponseEntity<?> handleUsuarioNaoEncontrado(UsuarioNaoEncontradoEx exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", exception.getMessage(), "code", HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(CredenciaisInvalidasEx.class)
    public ResponseEntity<?> handleCredenciaisInvalidas(CredenciaisInvalidasEx exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", exception.getMessage(), "code",HttpStatus.UNAUTHORIZED));
    }
}
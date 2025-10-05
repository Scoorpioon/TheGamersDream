package com.gamerdream.backend.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNaoEncontradoEx extends RuntimeException {
    public UsuarioNaoEncontradoEx(String msg) {
        super(msg);
    }
}
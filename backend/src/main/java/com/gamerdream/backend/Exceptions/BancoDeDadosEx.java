package com.gamerdream.backend.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class BancoDeDadosEx extends RuntimeException {
    public BancoDeDadosEx(String msg) {
        super(msg);
    }
}
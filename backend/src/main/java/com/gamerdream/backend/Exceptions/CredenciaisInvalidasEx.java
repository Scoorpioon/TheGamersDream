package com.gamerdream.backend.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class CredenciaisInvalidasEx extends RuntimeException {
    public CredenciaisInvalidasEx(String msg) {
        super(msg);
    }
}
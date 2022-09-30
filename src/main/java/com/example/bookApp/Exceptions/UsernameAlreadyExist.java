package com.example.bookApp.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UsernameAlreadyExist extends ResponseStatusException {
    public UsernameAlreadyExist(String reason) {
        super(HttpStatus.CONFLICT,reason);
    }
}

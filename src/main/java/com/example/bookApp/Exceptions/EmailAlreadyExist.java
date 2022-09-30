package com.example.bookApp.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmailAlreadyExist extends ResponseStatusException {
    public EmailAlreadyExist(String reason) {
        super(HttpStatus.CONFLICT, reason);
    }
}

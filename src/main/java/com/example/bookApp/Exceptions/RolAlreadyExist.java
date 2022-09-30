package com.example.bookApp.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RolAlreadyExist extends ResponseStatusException {
    public RolAlreadyExist(String reason) {
        super(HttpStatus.CONFLICT, reason);
    }
}

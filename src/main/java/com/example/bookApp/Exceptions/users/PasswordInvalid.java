package com.example.bookApp.Exceptions.users;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PasswordInvalid extends ResponseStatusException {
    public PasswordInvalid(String reason) {
        super(HttpStatus.UNAUTHORIZED, reason);
    }
}

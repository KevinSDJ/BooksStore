package com.bookStore.bookApp.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AlreadyExist extends ResponseStatusException {

    public AlreadyExist(String reason) {
        super(HttpStatus.CONFLICT, reason);
    }

}

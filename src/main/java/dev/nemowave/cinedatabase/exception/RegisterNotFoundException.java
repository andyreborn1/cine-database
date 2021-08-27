package dev.nemowave.cinedatabase.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RegisterNotFoundException extends Exception {

    public RegisterNotFoundException(String movieName) {
        super(String.format("Register with name %s not found", movieName));
    }

    public RegisterNotFoundException(long id) {
        super(String.format("Register with id %d not found", id));
    }
}

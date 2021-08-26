package dev.nemowave.cinedatabase.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends Exception {

    public MovieNotFoundException(String movieName) {
        super(String.format("Movie with name %s not found", movieName));
    }

    public MovieNotFoundException(long id) {
        super(String.format("Movie with id %d not found", id));
    }
}

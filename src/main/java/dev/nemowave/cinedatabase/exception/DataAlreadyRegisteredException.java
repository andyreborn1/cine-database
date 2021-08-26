package dev.nemowave.cinedatabase.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataAlreadyRegisteredException extends Exception{

    public DataAlreadyRegisteredException(String name){
        super(String.format("Data with name %s alread registered", name));
    }
}

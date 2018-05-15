package com.walter_moscardini.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SimpleCustomException extends RuntimeException {

    public SimpleCustomException(String message) {
        super(message);
    }
}

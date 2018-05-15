package com.walter_moscardini.Controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.walter_moscardini.Exceptions.SimpleCustomException;
import com.walter_moscardini.Model.ErrorDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandlerController {

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
//        System.out.println(ex.getClass());
//        return new ResponseEntity<Object>(new ErrorDetails(ex.getLocalizedMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<Object> handleJsonParseException(JsonParseException ex, WebRequest request) {
        return new ResponseEntity<Object>(new ErrorDetails(ex.getLocalizedMessage()), new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        return new ResponseEntity<Object>(new ErrorDetails(ex.getLocalizedMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SimpleCustomException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(SimpleCustomException ex, WebRequest request) {
        return new ResponseEntity<Object>(new ErrorDetails(ex.getLocalizedMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}

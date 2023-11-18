package com.cbfacademy.apiassessment.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CompanyDoesNotExistException extends ResponseStatusException{

    public CompanyDoesNotExistException(HttpStatus status, String message){
        super(status, message);

    }
}

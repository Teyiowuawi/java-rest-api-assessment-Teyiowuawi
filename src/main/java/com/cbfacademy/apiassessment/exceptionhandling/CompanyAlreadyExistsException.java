package com.cbfacademy.apiassessment.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CompanyAlreadyExistsException extends ResponseStatusException{

    public CompanyAlreadyExistsException(HttpStatus status, String message){
        super(status, message);

    }
}


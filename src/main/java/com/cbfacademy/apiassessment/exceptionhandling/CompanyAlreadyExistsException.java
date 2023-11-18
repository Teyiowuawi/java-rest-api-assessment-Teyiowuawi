package com.cbfacademy.apiassessment.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CompanyAlreadyExistsException extends ResponseStatusException{
   
    private String message; 

    public CompanyAlreadyExistsException(HttpStatus status, String message){
        super();
        // remove the messaeg aspect 
        // add the status code
    }
}


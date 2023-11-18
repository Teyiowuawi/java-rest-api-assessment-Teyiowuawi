package com.cbfacademy.apiassessment.exceptionhandling;

public class CompanyAlreadyExistsException extends RuntimeException{

    public CompanyAlreadyExistsException(String message){
        super(message);

    }
}


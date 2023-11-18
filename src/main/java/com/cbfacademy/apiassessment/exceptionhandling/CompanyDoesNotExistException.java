package com.cbfacademy.apiassessment.exceptionhandling;

public class CompanyDoesNotExistException extends RuntimeException{

    public CompanyDoesNotExistException(String message){
        super(message);
    }
}

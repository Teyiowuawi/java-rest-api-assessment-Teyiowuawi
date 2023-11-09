package com.cbfacademy.apiassessment.exceptionhandling;

public class CompanyAlreadyExistsException extends RuntimeException{
   
    private String message; 

    public CompanyAlreadyExistsException(){}

    public CompanyAlreadyExistsException(String msg){
        super(msg);
        this.message = msg;
    }
}


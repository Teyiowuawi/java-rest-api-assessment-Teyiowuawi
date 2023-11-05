package com.cbfacademy.apiassessment.exceptionhandling;

public class CompanyDoesNotExistException extends RuntimeException{
   
    private String message; 

    public CompanyDoesNotExistException(){}

    public CompanyDoesNotExistException(String msg){
        super(msg);
        this.message = msg;
    }
    
}

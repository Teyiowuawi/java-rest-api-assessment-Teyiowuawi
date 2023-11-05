package com.cbfacademy.apiassessment.exceptionhandling;

public class CompanyDoesNotExistException extends RuntimeException{
   
    private String message; 

    public CompanyDoesNotExistException(){}

    public CompanyDoesNotExistException(String msg){
        super(msg);
        this.message = msg;
    }
    // still printing the stack trace - how could i get ride of it?
    // or will it always be there and my useful message is the part that comes through
    
}

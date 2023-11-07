package com.cbfacademy.apiassessment.exceptionhandling;

public class CompanyAlreadyExistsException extends RuntimeException{
   
    private String message; 
    

    public CompanyAlreadyExistsException(){}

    public CompanyAlreadyExistsException(String msg){
        super(msg);
        this.message = msg;
    }
    // trying to place the status code here to print our what sort of status message it is
    // but having no luck and not seeing the result in POSTMAN
}


package com.cbfacademy.apiassessment.exceptionhandling;

public class CompanyDoesNotExistException extends RuntimeException{
   
    private String message; 

    public CompanyDoesNotExistException(){}

    public CompanyDoesNotExistException(String msg){
        super(msg);
        this.message = msg;
    }   
    // trying to place the status code here to print our what sort of status message it is
    // but having no luck and not seeing the result in my API tester
}

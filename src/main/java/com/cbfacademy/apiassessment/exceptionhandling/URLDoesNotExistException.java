package com.cbfacademy.apiassessment.exceptionhandling;

public class URLDoesNotExistException {

    private String message; 

    public URLDoesNotExistException(){}

    public URLDoesNotExistException(String msg){
        super(msg);
        this.message = msg;
    }
    
}

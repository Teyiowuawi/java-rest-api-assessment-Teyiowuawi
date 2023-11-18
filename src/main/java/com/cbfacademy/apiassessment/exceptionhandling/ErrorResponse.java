package com.cbfacademy.apiassessment.exceptionhandling;

public class ErrorResponse {

    private int errorCode;
    private String message; 

    public ErrorResponse(int statusCode, String message){
        this.errorCode = statusCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

        public void setErrorCode(int statusCode) {
        this.errorCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    

    

}

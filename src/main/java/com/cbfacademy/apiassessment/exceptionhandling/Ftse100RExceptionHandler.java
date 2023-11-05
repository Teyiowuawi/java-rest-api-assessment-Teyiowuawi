package com.cbfacademy.apiassessment.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class Ftse100RExceptionHandler {
    
@ExceptionHandler(CompanyDoesNotExistException.class)
public ResponseEntity<Object> handleCompanyDoesNotExistException(CompanyDoesNotExistException e){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
}

@ExceptionHandler(CompanyAlreadyExistsException.class)
public @ResponseBody ErrorResponse handleCompanyAlreadyExistsException(CompanyAlreadyExistsException e){
    return new ErrorResponse(
        HttpStatus.ALREADY_REPORTED.value(), e.getMessage());
}
    // still printing the stack trace - how could i get ride of it?
    // or will it always be there and my useful message is the part that comes through
}


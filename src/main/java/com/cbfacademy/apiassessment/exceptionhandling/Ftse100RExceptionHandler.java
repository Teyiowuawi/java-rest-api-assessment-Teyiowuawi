package com.cbfacademy.apiassessment.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class Ftse100RExceptionHandler {

@ResponseBody
@ExceptionHandler(CompanyDoesNotExistException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
public String handleCompanyDoesNotExistException(CompanyDoesNotExistException e){
    return e.getMessage();
}

// @ExceptionHandler(CompanyAlreadyExistsException.class)
// public @ResponseBody ErrorResponse handleCompanyAlreadyExistsException(CompanyAlreadyExistsException e){
//     return new ErrorResponse(
//         HttpStatus.ALREADY_REPORTED.value(), e.getMessage());
}
    // still printing the stack trace - how could i get ride of it?
    // or will it always be there and my useful message is the part that comes through



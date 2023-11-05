package com.cbfacademy.apiassessment.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class Ftse100RExceptionHandler {
    
@ExceptionHandler(value = CompanyDoesNotExistException.class)
public @ResponseBody ErrorResponse handleCompanyDoesNotException(CompanyDoesNotExistException e){
    return new ErrorResponse(
        HttpStatus.NOT_FOUND.value(), e.getMessage());
}

@ExceptionHandler(value = CompanyAlreadyExistsException.class)
public @ResponseBody ErrorResponse handleCompanyAlreadyExistsException(CompanyAlreadyExistsException e){
    return new ErrorResponse(
        HttpStatus.ALREADY_REPORTED.value(), e.getMessage());
}

}


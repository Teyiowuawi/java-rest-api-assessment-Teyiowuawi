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
public ResponseEntity<ErrorResponse> handleCompanyDoesNotExistException(CompanyDoesNotExistException e){
    ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
}


@ResponseBody
@ExceptionHandler(CompanyAlreadyExistsException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
public ResponseEntity<ErrorResponse> handleCompanyAlreadyExistsException(CompanyDoesNotExistException e){
    ErrorResponse errorResponse = new ErrorResponse(HttpStatus.FORBIDDEN.value(), e.getMessage());
    return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
}
}




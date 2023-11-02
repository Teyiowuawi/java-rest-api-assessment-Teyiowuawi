// package com.cbfacademy.apiassessment;


// import java.time.ZonedDateTime;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;

// import com.cbfacademy.apiassessment.ApiException;

// @ControllerAdvice
// public class ApiExceptionHandler {
    
//     @ExceptionHandler(value = {ApiRequestException.class})
//     public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
//         HttpStatus notFound = HttpStatus.NOT_FOUND;
//         ApiException apiException = new ApiException(
//             ZonedDateTime.now(),
//             HttpStatus.NOT_FOUND, 
//             ("Client side error"),
//             e.getMessage()
//             );

//         return new ResponseEntity<>(apiException, notFound);
        
//     }
// }


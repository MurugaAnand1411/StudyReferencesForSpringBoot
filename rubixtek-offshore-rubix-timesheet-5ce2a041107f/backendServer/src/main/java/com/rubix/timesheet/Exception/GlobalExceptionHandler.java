package com.rubix.timesheet.Exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author 
 * @class GlobalExceptionHandler 
 * The Error handling  is done by this class
 */

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
    /**
     * @param exception
     * @param request
     * @return the error message when the URL is undefined
     */
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(IdNotFoundException exception, WebRequest request) {
         ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    } 
    /**
     * @param exception
     * @param request
     * @return the error message when the @RequestBody is not met the condition
     */
    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<?> alreadyExistsException(AlreadyExistsException exception, WebRequest request) {
         ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    } 
    
    
    /**
     * @param exception
     * @param request
     * @return the error message when there error in server
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

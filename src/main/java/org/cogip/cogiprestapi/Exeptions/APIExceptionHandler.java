package org.cogip.cogiprestapi.Exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(value = {IdNotFoundException.class})
    public ResponseEntity<Object> handelIdNotFoundException(IdNotFoundException idNotFoundException){
        APIException apiException = new APIException(idNotFoundException.getMessage(),idNotFoundException.getCause(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {DuplicateValueException.class})
    public ResponseEntity<Object> handleDuplicateValueException(DuplicateValueException duplicateValueException){
        APIException apiException = new APIException(duplicateValueException.getMessage(),duplicateValueException.getCause(),HttpStatus.CONFLICT);
        return new ResponseEntity<>(apiException, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {InvalidInputException.class})
    public ResponseEntity<Object> handleInvalidInputException(InvalidInputException invalidInputException){
        APIException apiException = new APIException(invalidInputException.getMessage(),invalidInputException.getCause(),HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(apiException,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {MissingParametersException.class})
    public ResponseEntity<Object> handleMissingParametersException(MissingParametersException missingParametersException){
        APIException apiException = new APIException(missingParametersException.getMessage(),missingParametersException.getCause(),HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NotLoggedInException.class})
    public ResponseEntity<Object> handleNotLoggedInException(NotLoggedInException notLoggedInException){
        APIException apiException = new APIException(notLoggedInException.getMessage(),notLoggedInException.getCause(),HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(apiException,HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = {ResultSetEmptyException.class})
    public ResponseEntity<Object> handleResultSetEmptyException(ResultSetEmptyException resultSetEmptyException){
        APIException apiException = new APIException(resultSetEmptyException.getMessage(), resultSetEmptyException.getCause(), HttpStatus.SERVICE_UNAVAILABLE);
        return new ResponseEntity<>(apiException, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(value = {AccessDeniedException.class})
    public ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException accessDeniedException){
        APIException apiException = new APIException(accessDeniedException.getMessage(),accessDeniedException.getCause(),HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(apiException,HttpStatus.UNAUTHORIZED);
    }

}
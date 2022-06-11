package com.example.cookbuilder.Advice;

import com.example.cookbuilder.DTO.ResponseAPI;
import com.example.cookbuilder.Exception.DietTypeException;
import com.example.cookbuilder.Exception.NoAllergiesFound;
import com.example.cookbuilder.Exception.NoCuisineFound;
import com.example.cookbuilder.Exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class ControllerAdviseHandler {
    Logger logger = LoggerFactory.getLogger(ControllerAdviseHandler.class);
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<ResponseAPI> handleUserNotFoundException(UserNotFoundException userNotFoundException){
        logger.error("UserNotFoundException was triggered");
        String message = userNotFoundException.getMessage();
        return ResponseEntity.status(400).body(new ResponseAPI(message,400));
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseAPI> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        logger.error("MethodArgumentNotValidException was triggered");
        String message = methodArgumentNotValidException.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new ResponseAPI(message,400));
    }
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<ResponseAPI> handleDataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException){
        logger.error("DataIntegrityViolationException was triggered");
        String message = dataIntegrityViolationException.getRootCause().getMessage();
        return ResponseEntity.status(400).body(new ResponseAPI(message,400));
    }
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<ResponseAPI> handleHttpClientErrorException(HttpClientErrorException.NotFound httpClientErrorException){
        logger.error("HttpClientErrorException.NotFound was triggered");
        String message = httpClientErrorException.getMessage();
        return ResponseEntity.status(404).body(new ResponseAPI(message,404));
    }
    @ExceptionHandler(DietTypeException.class)
    public ResponseEntity<ResponseAPI> handleDietTypeException(DietTypeException dietTypeException){
        logger.error("DietTypeException was triggered");
        String message = dietTypeException.getMessage();
        return ResponseEntity.status(400).body(new ResponseAPI(message,400));
    }
    @ExceptionHandler(NoCuisineFound.class)
    public ResponseEntity<ResponseAPI> handleNoCuisineFound (NoCuisineFound noCuisineFound){
        logger.error("NoCuisineFound was triggered");
        String message = noCuisineFound.getMessage();
        return ResponseEntity.status(400).body(new ResponseAPI(message,400));
    }
    @ExceptionHandler(NoAllergiesFound.class)
    public ResponseEntity<ResponseAPI> handleNoAllergiesFound(NoAllergiesFound noAllergiesFound){
        logger.error("NoAllergiesFound was triggered");
        String message = noAllergiesFound.getMessage();
        return ResponseEntity.status(400).body(new ResponseAPI(message, 400));
    }
}

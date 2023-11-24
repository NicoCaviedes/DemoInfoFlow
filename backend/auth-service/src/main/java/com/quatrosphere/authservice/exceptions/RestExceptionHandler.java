package com.quatrosphere.authservice.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quatrosphere.authservice.models.records.ErrorRecord;

@ControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(value = { AppException.class })
    @ResponseBody
    public ResponseEntity<ErrorRecord> handleException(AppException exception){
        return ResponseEntity.status(exception.getHttpStatus()).body(new ErrorRecord(exception.getMessage()));
    }
}

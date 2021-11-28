package com.techiteasy.controllers;

import com.techiteasy.exceptions.BadRequestException;
import com.techiteasy.exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {


   @ExceptionHandler(value = RecordNotFoundException.class)
   public ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException exception) {
      return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
   }

   @ExceptionHandler(value = BadRequestException.class)
   public ResponseEntity<Object> handleBadRequestException(BadRequestException exception) {
      return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
   }


}

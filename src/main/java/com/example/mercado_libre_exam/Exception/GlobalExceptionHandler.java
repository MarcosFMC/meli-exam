package com.example.mercado_libre_exam.Exception;


import com.example.mercado_libre_exam.Model.DTOs.ErrorMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidCharactersException.class)
    public ResponseEntity<ErrorMessageDTO> handleInvalidCharacters(InvalidCharactersException e) {

        ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessageDTO);
    }

    @ExceptionHandler(EmptyDNASequenceException.class)
    public ResponseEntity<ErrorMessageDTO> handleEmptyDnaSequence(EmptyDNASequenceException e) {

        ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessageDTO);
    }

}

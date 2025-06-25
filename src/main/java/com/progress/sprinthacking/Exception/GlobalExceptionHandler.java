package com.progress.sprinthacking.Exception;

import com.progress.sprinthacking.DTO.ResponseDTO;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ResponseDTO> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
        return new ResponseEntity<>(ResponseDTO.error("Data integrity violation: Possible duplicate entry or constraint violation. " + ex.getMessage()),
            HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnexpectedRollbackException.class)
    public ResponseEntity<ResponseDTO> handleUnexpectedRollbackException(UnexpectedRollbackException ex, WebRequest request) {
        return new ResponseEntity<>(ResponseDTO.error("Transaction rolled back: " + ex.getMessage()),
            HttpStatus.INTERNAL_SERVER_ERROR);
    }    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ResponseDTO> handleDataAccessException(DataAccessException ex, WebRequest request) {
        return new ResponseEntity<>(ResponseDTO.error("Database error: " + ex.getMessage()),
            HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseDTO> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        return new ResponseEntity<>(ResponseDTO.error(ex.getMessage()),
            HttpStatus.BAD_REQUEST);
    }
}

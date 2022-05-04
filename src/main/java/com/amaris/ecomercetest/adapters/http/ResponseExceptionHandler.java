package com.amaris.ecomercetest.adapters.http;

import com.amaris.ecomercetest.adapters.http.dto.ExceptionDto;
import com.amaris.ecomercetest.adapters.http.dto.mapper.ExceptionMapper;
import com.amaris.ecomercetest.app.exceptions.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerWebInputException;

@RestControllerAdvice
public class ResponseExceptionHandler {
    private final ExceptionMapper exceptionMapper;

    public ResponseExceptionHandler(ExceptionMapper exceptionMapper) {
        this.exceptionMapper = exceptionMapper;
    }

    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ExceptionDto> handleApplicationException(ApplicationException ex) {
        return new ResponseEntity<>(exceptionMapper.to(ex), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ServerWebInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionDto> handleInputException(ServerWebInputException ex) {
        return new ResponseEntity<>(exceptionMapper.to(ex), ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ExceptionDto> handleAnyException(Exception ex) {
        return new ResponseEntity<>(exceptionMapper.to(ex), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

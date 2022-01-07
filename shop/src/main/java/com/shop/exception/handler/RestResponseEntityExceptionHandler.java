package com.shop.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }


    @ExceptionHandler(value = Exception.class)
    public @ResponseBody
    ResponseEntity<Object> handleUnexpectedException(Exception e) {
        logger.error(e.getMessage());
        e.printStackTrace();
        ApiError apiError = new ApiError(NOT_FOUND, e.getMessage());
        return buildResponseEntity(apiError);
    }
}


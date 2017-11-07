package com.zyr.book.handler;

import com.zyr.book.domain.Error;
import com.zyr.book.enums.ApiErrorType;
import com.zyr.book.exception.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler
    public ResponseEntity<Error> handle(Exception e) {
        if (e instanceof UserException) {
            return new ResponseEntity<>(new Error(((UserException) e).getApiErrorType().getMessage()),
                    HttpStatus.BAD_REQUEST);
        } else if (e instanceof DataIntegrityViolationException) {
            return new ResponseEntity<>(new Error(ApiErrorType.DUPLICATED_BOOK.getMessage()),
                    HttpStatus.FORBIDDEN);
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            return new ResponseEntity<>(new Error(e.getLocalizedMessage()),
                    HttpStatus.METHOD_NOT_ALLOWED);
        } else {
            logger.error("【系统异常】", e);
            return new ResponseEntity<>(new Error(ApiErrorType.UNKNOWN_ERROR.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

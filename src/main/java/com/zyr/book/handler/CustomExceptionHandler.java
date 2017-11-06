package com.zyr.book.handler;

import com.zyr.book.domain.Response;
import com.zyr.book.enums.ApiErrorType;
import com.zyr.book.exception.UserException;
import com.zyr.book.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CustomExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler
    public Response handle(Exception e) {
        if (e instanceof UserException) {
            return ResponseUtil.error(((UserException) e).getApiErrorType());
        } else if (e instanceof DataIntegrityViolationException) {
            return ResponseUtil.error(ApiErrorType.DUPLICATED_BOOK);
        } else {
            logger.error("【系统异常】", e);
            return ResponseUtil.error(ApiErrorType.UNKNOWN_ERROR);
        }
    }
}

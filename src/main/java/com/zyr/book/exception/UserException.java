package com.zyr.book.exception;

import com.zyr.book.enums.ApiErrorType;

public class UserException extends RuntimeException {

    private ApiErrorType apiErrorType;

    public UserException(ApiErrorType apiErrorType) {
        super(apiErrorType.getMessage());
        this.apiErrorType = apiErrorType;
    }

    public ApiErrorType getApiErrorType() {
        return apiErrorType;
    }

    public void setApiErrorType(ApiErrorType apiErrorType) {
        this.apiErrorType = apiErrorType;
    }
}

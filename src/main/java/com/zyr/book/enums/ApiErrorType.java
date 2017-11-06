package com.zyr.book.enums;

public enum ApiErrorType {
    UNKNOWN_ERROR(-1, "服务器异常"),
    EMPTY_BOOK(100, "该用户没有书籍"),
    NULL_NAME(101, "姓名不能为空"),
    NULL_BOOK(102, "书籍不能为空"),
    DUPLICATED_BOOK(103, "该用户已有此书");

    private Integer code;
    private String message;

    ApiErrorType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

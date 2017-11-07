package com.zyr.book.enums;

public enum ApiErrorType {
    UNKNOWN_ERROR("服务器异常"),
    EMPTY_BOOK("该用户没有书籍"),
    NULL_NAME("姓名不能为空"),
    NULL_BOOK("书籍不能为空"),
    DUPLICATED_BOOK("该用户已有此书");

    private String message;

    ApiErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

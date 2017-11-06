package com.zyr.book.util;

import com.zyr.book.domain.Response;
import com.zyr.book.enums.ApiErrorType;

public class ResponseUtil {

    public static Response success(String message, Object data) {
        Response response = new Response();
        response.setCode(0);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    public static Response success(String message) {
        return success(message, null);
    }

    public static Response success(Object data) {
        Response response = new Response();
        response.setCode(0);
        response.setMessage("成功");
        response.setData(data);
        return response;
    }

    public static Response error(ApiErrorType apiErrorType) {
        Response response = new Response();
        response.setCode(apiErrorType.getCode());
        response.setMessage(apiErrorType.getMessage());
        return response;
    }
}

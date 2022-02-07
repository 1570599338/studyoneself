package com.zxj.shop.admin.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    Integer code;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ResponseCodeInterface code) {
        this(code.getCode(), code.getMsg());
    }
}

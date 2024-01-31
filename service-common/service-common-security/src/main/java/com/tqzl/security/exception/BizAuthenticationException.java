package com.tqzl.security.exception;

import org.springframework.http.HttpStatus;

/**
 * @Author ZhangGuoXiang
 * @Date [2024/1/30 12:03]
 * @Version [1.0]
 * @see [相关类/方法]
 * @since [产品/模板版本号]
 */
public class BizAuthenticationException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public BizAuthenticationException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public BizAuthenticationException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

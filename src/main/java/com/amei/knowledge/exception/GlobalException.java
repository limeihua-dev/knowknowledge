package com.amei.knowledge.exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

/**
 * 全局自定义异常类
 */
@Slf4j
public class GlobalException extends Exception {
    private HttpStatus httpStatus;
    private String errorMsg;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public GlobalException(HttpStatus httpStatus, String errorMsg) {
        log.info(errorMsg);
        this.httpStatus = httpStatus;
        this.errorMsg = errorMsg;
    }
}
